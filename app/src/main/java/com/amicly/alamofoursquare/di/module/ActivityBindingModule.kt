package com.amicly.playerbase.di.module

import com.amicly.alamofoursquare.search.SearchActivity
import com.amicly.playerbase.di.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector



/**
 * Created by darrankelinske on 2/11/18.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [(SearchModule::class)])
    internal abstract fun searchActivity(): SearchActivity

}