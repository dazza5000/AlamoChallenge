package com.amicly.alamofoursquare.venuesearch

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.alamofoursquare.venuemap.VenueMapActivity
import com.amicly.playerbase.base.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class VenueSearchActivity : BaseActivity(), VenueSearchContract.View {

    @Inject lateinit var searchPresenter : VenueSearchPresenter
    @Inject lateinit var venueRecyclerAdapter: VenueRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recycler_view_venues.adapter = venueRecyclerAdapter
        floating_action_button_venue_search.setOnClickListener { searchPresenter.mapClicked() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val eventsSearchView = searchItem.actionView as SearchView
        eventsSearchView.maxWidth = Integer.MAX_VALUE
        eventsSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchPresenter.searchQueryUpdated(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun showVenues(venues : List<Venue>) {
        venueRecyclerAdapter.setVenues(venues)
    }

    override fun navigateToMapView() {
        startActivity(Intent(this, VenueMapActivity::class.java))
    }
}
