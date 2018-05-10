package com.amicly.playerbase.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module


/**
 * Created by darrankelinske on 2/11/18.
 */
@Module
abstract class ApplicationModule {
    @Binds
    internal abstract fun bindContext(application: Application): Context
}