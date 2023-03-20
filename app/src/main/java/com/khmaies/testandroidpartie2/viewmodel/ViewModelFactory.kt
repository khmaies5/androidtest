package com.khmaies.testandroidpartie2.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khmaies.testandroidpartie2.datasource.AppDatabase
import com.khmaies.testandroidpartie2.repository.PersonneRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
class ViewModelFactory private constructor(private val application: Application) : ViewModelProvider.Factory {

    companion object {
        private var instance: ViewModelFactory? = null

        fun initialize(application: Application) {
            synchronized(this) {
                if (instance == null) {
                    instance = ViewModelFactory(application)
                }
            }
        }

        fun getInstance(): ViewModelFactory {
            return instance ?: throw ExceptionInInitializerError("You must initialize the factory with 'fun initialize(Application)'.")
        }
    }
    val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { AppDatabase.getDatabaseInstance(application, applicationScope) }
    private val repository by lazy { PersonneRepository(database.personneDao()) }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            PersonneViewModel::class.java -> PersonneViewModel(repository) as T
            else -> throw IllegalArgumentException("No class found for '${modelClass.name}'")
        }
    }
}