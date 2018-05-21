package com.amicly.alamofoursquare.venuesearchmap

import com.amicly.alamofoursquare.common.scheduler.SchedulerProvider
import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.model.venue.VenueSearchResult
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber
import javax.inject.Inject


class VenueMapPresenter @Inject constructor(private val view : VenueMapContract.View,
                                            private val fourSquareService: FourSquareService,
                                            private val schedulerProvider: SchedulerProvider):
        VenueMapContract.Presenter {

    override fun searchVenues(searchString: String) {
        fourSquareService.searchEvents(searchString)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(object : DisposableSingleObserver<VenueSearchResult>() {

                    override fun onSuccess(searchResult: VenueSearchResult) {
                        searchResult.response?.venues?.let {
                            view.showVenues(it)
                        }
                    }

                    override fun onError(e: Throwable) {
                        Timber.e(e)
                        view.showNotification(e.toString())
                    }
                })
    }
}