package com.amicly.alamofoursquare.search

import com.amicly.alamofoursquare.model.Venue
import com.amicly.playerbase.base.mvp.BaseContract

interface SearchContract {
    interface Presenter {
        fun selectEvent(venue: Venue)
        fun searchQueryUpdated(newText: String)
    }
    interface View : BaseContract.View {
        fun showVenues(venues: List<Venue>)
    }
}