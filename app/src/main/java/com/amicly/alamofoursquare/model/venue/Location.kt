package com.amicly.alamofoursquare.model.venue

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("crossStreet")
    @Expose
    var crossStreet: String? = null
    @SerializedName("lat")
    @Expose
    var lat: Double = 0.toDouble()
    @SerializedName("lng")
    @Expose
    var lng: Double = 0.toDouble()
    @SerializedName("postalCode")
    @Expose
    var postalCode: String? = null
    @SerializedName("cc")
    @Expose
    var cc: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("formattedAddress")
    @Expose
    var formattedAddress: List<String>? = null

}
