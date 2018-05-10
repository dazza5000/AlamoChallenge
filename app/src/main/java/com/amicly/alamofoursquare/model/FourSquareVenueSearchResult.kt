package com.amicly.alamofoursquare.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FourSquareVenueSearchResult {

    @SerializedName("meta")
    @Expose
    var meta: Meta? = null

    @SerializedName("response")
    @Expose
    var response: Response? = null

}
