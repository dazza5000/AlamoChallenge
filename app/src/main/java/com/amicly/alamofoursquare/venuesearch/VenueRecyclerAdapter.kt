package com.amicly.alamofoursquare.venuesearch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.common.image.GlideApp
import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.inflate
import com.amicly.alamofoursquare.model.photo.Item
import com.amicly.alamofoursquare.model.photo.PhotoSearchResult
import com.amicly.alamofoursquare.model.venue.Venue
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_venue.view.*

class VenueRecyclerAdapter (private var venues: List<Venue>,
                            private val venueClickListener: VenueClickListener,
                            private val fourSquareService: FourSquareService)
    : RecyclerView.Adapter<VenueRecyclerAdapter.VenueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val view = parent.inflate(R.layout.item_venue)
        return VenueViewHolder(view, venueClickListener)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        val venue = venues[position]
        holder.bindEvent(venue)
    }

    override fun getItemCount(): Int {
        return venues.size
    }

    fun setVenues(places: List<Venue>) {
        this.venues = places
        notifyDataSetChanged()
    }

    override fun onViewRecycled(holder: VenueViewHolder) {
        super.onViewRecycled(holder)
        holder.disposables.clear()
        GlideApp.with(holder.itemView).clear(holder.itemView.image_view_event_image)
        holder.itemView.image_view_event_image
                .setImageResource(R.drawable.ic_sentiment_satisfied_24dp)
    }

    inner class VenueViewHolder(private val venueItemView: View,
                                private val venueClickListener: VenueClickListener)
        : RecyclerView.ViewHolder(venueItemView) {

        val disposables : CompositeDisposable = CompositeDisposable()

        fun bindEvent(venue: Venue) {
            venueItemView.text_view_venue_name.text = venue.name
            venueItemView.text_view_venue_location.text = venue.location?.address
            venueItemView.text_view_event_url.text = venue.url

            venueItemView.setOnClickListener { _ -> venueClickListener.onVenueClick(venue) }


            venue.id?.let {
                disposables.add(fourSquareService.getPhotos(it)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(Consumer { loadPhotoResult(it) }))
            }
        }

        private fun loadPhotoResult(photoSearchResult: PhotoSearchResult) {

            photoSearchResult.response?.photos?.items?.let {
                if (it.isEmpty()) return
                GlideApp.with(venueItemView.context)
                        .load(getImageUrlFromSearchResult(photoSearchResult))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .transforms(CenterCrop(), RoundedCorners(7))
                        .into(venueItemView.image_view_event_image)
            }
        }

        private fun getImageUrlFromSearchResult(photoSearchResult: PhotoSearchResult) : String {

            var photoItem : Item = photoSearchResult.response?.photos?.items?.get(0) ?: Item()
            var imageUrl = ""
            imageUrl += photoItem.prefix + "300" + photoItem.suffix
            return imageUrl
        }
    }

    interface VenueClickListener {
        fun onVenueClick(venue: Venue)
    }
}
