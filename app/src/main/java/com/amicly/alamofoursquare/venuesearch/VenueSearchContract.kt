package com.amicly.alamofoursquare.venuesearch

import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.playerbase.base.mvp.BaseContract

interface VenueSearchContract {
    interface Presenter : BaseContract.Presenter {
        fun selectEvent(venue: Venue)
        fun searchQueryUpdated(newText: String)
        fun mapClicked()
    }
    interface View : BaseContract.View {
        fun showVenues(venues: List<Venue>)
        fun navigateToMapView(searchString: String)
        fun showMapButton(show: Boolean)
    }
}