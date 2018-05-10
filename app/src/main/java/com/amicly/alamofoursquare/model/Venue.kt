package com.amicly.alamofoursquare.model

import android.location.Location
import android.view.Menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Venue {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("verified")
    @Expose
    var isVerified: Boolean = false
    @SerializedName("venueRatingBlacklisted")
    @Expose
    var isVenueRatingBlacklisted: Boolean = false
    @SerializedName("referralId")
    @Expose
    var referralId: String? = null
    @SerializedName("hasPerk")
    @Expose
    var isHasPerk: Boolean = false
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("allowMenuUrlEdit")
    @Expose
    var isAllowMenuUrlEdit: Boolean = false
    @SerializedName("storeId")
    @Expose
    var storeId: String? = null
    @SerializedName("hasMenu")
    @Expose
    var isHasMenu: Boolean = false
    @SerializedName("menu")
    @Expose
    var menu: Menu? = null
}
