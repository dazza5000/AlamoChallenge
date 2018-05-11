package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.di.scope.ActivityScoped
import com.amicly.alamofoursquare.venuesearch.VenueSearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector



/**
 * Created by darrankelinske on 2/11/18.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [(SearchModule::class)])
    internal abstract fun searchActivity(): VenueSearchActivity

}