package com.amicly.alamofoursquare.data.remote;

import com.amicly.alamofoursquare.model.photo.PhotoSearchResult;
import com.amicly.alamofoursquare.model.venue.VenueSearchResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FourSquareService {

    String VENUES = "venues";
    String SEARCH_NEAR_AUSTIN = VENUES + "/search?near=Austin,TX";
    String PHOTOS = VENUES + "/{venueId}/photos";

    @GET(SEARCH_NEAR_AUSTIN)
    Single<VenueSearchResult> searchEvents(@Query("query") String searchQuery);

    @GET(PHOTOS)
    Single<PhotoSearchResult> getPhotos(@Path("venueId") String venueId);
}
