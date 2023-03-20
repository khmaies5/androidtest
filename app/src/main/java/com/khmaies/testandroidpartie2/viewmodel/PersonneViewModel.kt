package com.khmaies.testandroidpartie2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.khmaies.testandroidpartie2.model.Personne
import com.khmaies.testandroidpartie2.repository.PersonneRepository
import kotlinx.coroutines.launch

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
class PersonneViewModel(private val repository: PersonneRepository) : ViewModel() {

    val allPersonnes: LiveData<List<Personne>> = repository.allPersonnes.asLiveData()

    fun insert(personne: Personne) = viewModelScope.launch {
        repository.insert(personne)
    }

}