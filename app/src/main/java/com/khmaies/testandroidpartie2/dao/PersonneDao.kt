package com.khmaies.testandroidpartie2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khmaies.testandroidpartie2.model.Personne
import kotlinx.coroutines.flow.Flow

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
@Dao
interface PersonneDao {

    @Query("Select * from Personne ORDER BY prenom ASC")
    fun getAll(): Flow<List<Personne>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(personne: Personne)

}