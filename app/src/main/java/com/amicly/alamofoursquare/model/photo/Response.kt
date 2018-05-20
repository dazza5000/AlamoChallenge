package com.amicly.alamofoursquare.model.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("photos")
    @Expose
    var photos: Photos? = null

}
