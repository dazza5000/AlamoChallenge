package com.amicly.alamofoursquare.venuemap

import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.playerbase.base.mvp.BaseContract

interface VenueMapContract {
    interface View : BaseContract.View {
        fun showVenues(venus: List<Venue>)
    }
    interface Presenter : BaseContract.Presenter {}
}
