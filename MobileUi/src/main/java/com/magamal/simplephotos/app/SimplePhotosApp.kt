package com.magamal.simplephotos.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
@HiltAndroidApp
class SimplePhotosApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: SimplePhotosApp
            private set
    }
}