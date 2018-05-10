package com.amicly.alamofoursquare

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class AlamoFourSquareApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }
}