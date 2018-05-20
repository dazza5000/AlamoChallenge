package com.amicly.alamofoursquare.model.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PhotoSearchResult {

    @SerializedName("response")
    @Expose
    var response: Response? = null

}
