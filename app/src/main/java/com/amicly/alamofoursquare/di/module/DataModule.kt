package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.common.scheduler.AppSchedulerProvider
import com.amicly.alamofoursquare.common.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides


/**
 * Created by darrankelinske on 2/11/18.
 */

@Module
class DataModule {
    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}