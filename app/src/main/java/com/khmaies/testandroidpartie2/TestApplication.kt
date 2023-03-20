package com.khmaies.testandroidpartie2

import android.app.Application
import com.khmaies.testandroidpartie2.viewmodel.ViewModelFactory

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
class TestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ViewModelFactory.initialize(this)
    }
}