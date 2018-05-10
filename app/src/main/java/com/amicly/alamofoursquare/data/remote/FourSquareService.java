package com.amicly.alamofoursquare.data.remote;

import com.amicly.alamofoursquare.model.FourSquareVenueSearchResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FourSquareService {

    public static final String SEARCH_NEAR_AUSTIN = "venues/search?near=Austin,TX";

    @GET(SEARCH_NEAR_AUSTIN)
    Single<FourSquareVenueSearchResult> searchEvents(@Query("query") String searchQuery);
}
