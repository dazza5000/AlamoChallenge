package com.amicly.alamofoursquare.venuedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.venuesearchmap.VenueMapActivity
import com.amicly.playerbase.base.mvp.BaseActivity

class VenueDetailActivity : BaseActivity(), VenueDetailContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)
    }

    companion object {
        private const val EXTRA_VENUE_ID = "venueId"

        fun startVenueDetailActivity(context: Context, searchString: String) {
            val intent = Intent(context, VenueDetailActivity::class.java)
            intent.putExtra(EXTRA_VENUE_ID, searchString)
            context.startActivity(intent)
        }
    }
}
