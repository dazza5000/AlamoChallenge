package com.amicly.alamofoursquare.di.module

import com.amicly.alamofoursquare.venuesearchmap.VenueMapActivity
import com.amicly.alamofoursquare.venuesearchmap.VenueMapContract
import dagger.Binds
import dagger.Module

@Module
abstract class VenueMapModule {

    @Binds
    abstract fun venuMapView(venueMapActivity: VenueMapActivity): VenueMapContract.View

}