package com.amicly.alamofoursquare.search

import android.os.Bundle
import com.amicly.alamofoursquare.R
import com.amicly.playerbase.base.mvp.BaseActivity
import javax.inject.Inject

class SearchActivity : BaseActivity(), SearchContract.View {

    @Inject lateinit var presenter : SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}
