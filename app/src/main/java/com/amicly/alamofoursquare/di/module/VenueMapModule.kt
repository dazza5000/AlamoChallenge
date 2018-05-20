package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.venuemap.VenueMapActivity
import com.amicly.alamofoursquare.venuemap.VenueMapContract
import com.amicly.alamofoursquare.venuesearch.VenueSearchActivity
import com.amicly.alamofoursquare.venuesearch.VenueSearchContract
import dagger.Binds
import dagger.Module

@Module
abstract class VenueMapModule {

    @Binds
    abstract fun venuMapView(venueMapActivity: VenueMapActivity): VenueMapContract.View

}