package com.khmaies.testandroidpartie2.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
object Helper {
    fun calculateAge(birthDate: String): Int {

        // Define the format of the input string using a DateTimeFormatter object
        val formatter = DateTimeFormatter.ofPattern("dd/M/yyyy")
        // Parse the input string into a LocalDate object using the formatter
        val birthDate = LocalDate.parse(birthDate, formatter)
        // Get the year of birth from the LocalDate object
        val yearOfBirth = birthDate.year
        // Get the current year from another LocalDate object
        val currentYear = LocalDate.now().year
        // Subtract the year of birth from the current year to get the age
        return currentYear - yearOfBirth
    }
}
