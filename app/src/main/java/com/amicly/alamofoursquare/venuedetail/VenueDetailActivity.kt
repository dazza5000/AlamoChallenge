package com.amicly.alamofoursquare.venuedetail

import android.os.Bundle
import com.amicly.alamofoursquare.R
import com.amicly.playerbase.base.mvp.BaseActivity

class VenueDetailActivity : BaseActivity(), VenueDetailContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)
    }
}
