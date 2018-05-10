package com.amicly.playerbase.base.mvp

/**
 * Created by darrankelinske on 2/11/18.
 */
interface BaseContract {
    interface View {
        fun showProgress(show : Boolean)
    }

    interface Presenter { }
}