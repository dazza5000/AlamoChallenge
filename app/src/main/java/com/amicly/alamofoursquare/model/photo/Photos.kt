package com.amicly.alamofoursquare.model.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photos {

    @SerializedName("count")
    @Expose
    var count: Int = 0
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
    @SerializedName("dupesRemoved")
    @Expose
    var dupesRemoved: Int = 0

}
