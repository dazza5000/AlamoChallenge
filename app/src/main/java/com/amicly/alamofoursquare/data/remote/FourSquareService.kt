package com.amicly.alamofoursquare.data.remote

import com.amicly.alamofoursquare.model.photo.PhotoSearchResult
import com.amicly.alamofoursquare.model.venue.VenueSearchResult

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FourSquareService {

    @GET(SEARCH_NEAR_AUSTIN)
    fun searchEvents(@Query("query") searchQuery: String): Single<VenueSearchResult>

    @GET(PHOTOS)
    fun getPhotos(@Path("venueId") venueId: String): Single<PhotoSearchResult>

    companion object {

        const val VENUES = "venues"
        const val SEARCH_NEAR_AUSTIN = "$VENUES/search?near=Austin,TX"
        const val PHOTOS = "$VENUES/{venueId}/photos"
    }
}
