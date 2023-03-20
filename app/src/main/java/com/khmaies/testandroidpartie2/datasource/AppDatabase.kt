package com.khmaies.testandroidpartie2.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.khmaies.testandroidpartie2.dao.PersonneDao
import com.khmaies.testandroidpartie2.model.Personne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
@Database(entities = [Personne::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personneDao() : PersonneDao

    private class PersonneDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    //val personneDao = database.personneDao()

                    //personneDao.deleteAll()

                    // add sample data

                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabaseInstance(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).addCallback(PersonneDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }

        }
    }
}
