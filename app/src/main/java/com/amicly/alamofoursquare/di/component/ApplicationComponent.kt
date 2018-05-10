package com.amicly.playerbase.di.component

import com.amicly.alamofoursquare.AlamoFourSquareApplication
import com.amicly.alamofoursquare.di.module.ActivityBindingModule
import com.amicly.alamofoursquare.di.module.ApplicationModule
import com.amicly.alamofoursquare.di.module.DataModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by darrankelinske on 2/11/18.
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ApplicationModule::class, ActivityBindingModule::class, DataModule::class])

interface ApplicationComponent : AndroidInjector<AlamoFourSquareApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AlamoFourSquareApplication): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(app: AlamoFourSquareApplication)
}