package com.amicly.alamofoursquare.search

import com.amicly.alamofoursquare.model.Venue
import com.amicly.playerbase.base.mvp.BaseContract

interface SearchContract {
    interface Presenter {
        fun selectEvent(venue: Venue)
    }
    interface View : BaseContract.View {
    }
}