package com.amicly.playerbase.base.mvp

import android.annotation.SuppressLint
import com.amicly.alamofoursquare.toast
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by darrankelinske on 2/11/18.
 */
@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity(), BaseContract.View {
    override fun showProgress(show: Boolean) {
        toast("loading...")
    }

    override fun showNotification(text: String) {
        toast(text)
    }
}