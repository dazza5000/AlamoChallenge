package com.amicly.alamofoursquare.search

import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.model.Venue
import com.amicly.playerbase.base.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*
import java.util.*
import javax.inject.Inject

class SearchActivity : BaseActivity(), SearchContract.View {

    @Inject lateinit var presenter : SearchPresenter

    private var venueRecyclerAdapter: VenueRecyclerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        venueRecyclerAdapter = VenueRecyclerAdapter(ArrayList(), object : VenueRecyclerAdapter.VenueClickListener {
            override fun onVenueClick(venue : Venue) {
                presenter.selectEvent(venue)
            }
        })
        recyclerview_venues.adapter = venueRecyclerAdapter
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
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}