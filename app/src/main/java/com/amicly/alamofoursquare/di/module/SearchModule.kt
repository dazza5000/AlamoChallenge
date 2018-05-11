package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.alamofoursquare.venuesearch.SearchActivity
import com.amicly.alamofoursquare.venuesearch.SearchContract
import com.amicly.alamofoursquare.venuesearch.SearchPresenter
import com.amicly.alamofoursquare.venuesearch.VenueRecyclerAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import java.util.*


/**
 * Created by darrankelinske on 2/11/18.
 */
@Module
abstract class SearchModule {
    @Binds
    abstract fun searchView(searchActivity : SearchActivity): SearchContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideVenueRecyclerAdapter(searchPresenter: SearchPresenter,
                                        fourSquareService: FourSquareService): VenueRecyclerAdapter {
            return VenueRecyclerAdapter(ArrayList(),
                    object : VenueRecyclerAdapter.VenueClickListener {
                        override fun onVenueClick(venue: Venue) {
                            searchPresenter.selectEvent(venue)
                        }
                    }, fourSquareService)
        }
    }
}