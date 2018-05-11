package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.alamofoursquare.venuesearch.VenueSearchActivity
import com.amicly.alamofoursquare.venuesearch.VenueSearchContract
import com.amicly.alamofoursquare.venuesearch.VenueSearchPresenter
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
    abstract fun searchView(searchActivity : VenueSearchActivity): VenueSearchContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideVenueRecyclerAdapter(searchPresenter: VenueSearchPresenter,
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