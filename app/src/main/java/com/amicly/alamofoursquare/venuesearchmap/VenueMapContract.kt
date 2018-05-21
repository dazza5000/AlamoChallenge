package com.amicly.alamofoursquare.venuesearchmap

import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.playerbase.base.mvp.BaseContract

interface VenueMapContract {
    interface View : BaseContract.View {
        fun showVenues(venues: List<Venue>)
    }
    interface Presenter : BaseContract.Presenter {
        fun searchVenues(searchString: String)
    }
}
