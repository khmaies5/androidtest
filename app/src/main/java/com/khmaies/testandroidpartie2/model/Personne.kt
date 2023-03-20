package com.khmaies.testandroidpartie2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
@Entity(tableName = "Personne")
data class Personne(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val nom: String,
    val prenom: String,
    @ColumnInfo(name = "date_de_naissance")
    val dateDeNaissance: String
)
