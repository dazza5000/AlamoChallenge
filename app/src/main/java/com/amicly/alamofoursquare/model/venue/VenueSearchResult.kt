package com.amicly.alamofoursquare.model.venue

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VenueSearchResult {

    @SerializedName("meta")
    @Expose
    var meta: Meta? = null

    @SerializedName("response")
    @Expose
    var response: Response? = null

}
