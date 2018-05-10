package com.amicly.alamofoursquare.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.model.Venue
import kotlinx.android.synthetic.main.item_venue.view.*

class VenueRecyclerAdapter(private var venues: List<Venue>?,
                           private val venueClickListener: VenueClickListener)
    : RecyclerView.Adapter<VenueRecyclerAdapter.VenueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_venue, parent,
                false)
        return VenueViewHolder(view, venueClickListener)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        val venue = venues!![position]
        holder.bindEvent(venue)
    }

    override fun getItemCount(): Int {
        return venues!!.size
    }

    fun setVenues(places: List<Venue>) {
        this.venues = places
        notifyDataSetChanged()
    }

    inner class VenueViewHolder(private val venueItemView: View,
                                private val venueClickListener: VenueClickListener) : RecyclerView.ViewHolder(venueItemView) {

        fun bindEvent(venue: Venue) {
            venueItemView.text_view_event_name.text = venue.name
            venueItemView.setOnClickListener { _ -> venueClickListener.onVenueClick(venue) }
        }
    }

    interface VenueClickListener {
        fun onVenueClick(event: Venue)
    }
}
