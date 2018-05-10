package com.amicly.alamofoursquare.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("venues")
    @Expose
    var venues: List<Venue>? = null
    @SerializedName("confident")
    @Expose
    var isConfident: Boolean = false
}
