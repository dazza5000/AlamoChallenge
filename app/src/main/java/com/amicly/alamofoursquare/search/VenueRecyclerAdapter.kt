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
        return VenueViewHolder(view)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        val venue = venues!![position]

        holder.itemView.setOnClickListener { _ -> venueClickListener.onVenueClick(venue) }
        holder.bindEvent(venue)
    }

    override fun getItemCount(): Int {
        return venues!!.size
    }

    fun setVenues(places: List<Venue>) {
        this.venues = places
        notifyDataSetChanged()
    }

    inner class VenueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
            View.OnClickListener {

        private var event: Venue? = null

        override fun onClick(v: View) {
        }

        fun bindEvent(event: Venue) {
            this.event = event
            itemView.text_view_event_name.text = event.id.toString()
        }
    }

    interface VenueClickListener {
        fun onVenueClick(event: Venue)
    }
}
