package com.amicly.alamofoursquare

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by darrankelinske on 1/25/18.
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun Context.toast(message:CharSequence) =
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
fun Context.toastLong(message:CharSequence) =
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()