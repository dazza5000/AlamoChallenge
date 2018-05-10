package com.amicly.alamofoursquare.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meta {

    @SerializedName("code")
    @Expose
    var code: Int = 0
    @SerializedName("requestId")
    @Expose
    var requestId: String? = null

}
