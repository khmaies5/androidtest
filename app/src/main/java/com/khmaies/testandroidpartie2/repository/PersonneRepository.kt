package com.khmaies.testandroidpartie2.repository

import com.khmaies.testandroidpartie2.dao.PersonneDao
import com.khmaies.testandroidpartie2.model.Personne
import kotlinx.coroutines.flow.Flow

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
class PersonneRepository(private val personneDao: PersonneDao) {

    val allPersonnes: Flow<List<Personne>> = personneDao.getAll()

    suspend fun insert(personne: Personne) {
        personneDao.insert(personne)
    }
}