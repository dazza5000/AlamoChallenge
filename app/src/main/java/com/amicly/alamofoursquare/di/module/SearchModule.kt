package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.search.SearchActivity
import com.amicly.alamofoursquare.search.SearchContract
import dagger.Binds
import dagger.Module




/**
 * Created by darrankelinske on 2/11/18.
 */
@Module
abstract class SearchModule {
    @Binds
    abstract fun searchView(searchActivity : SearchActivity): SearchContract.View

}