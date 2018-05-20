package com.amicly.alamofoursquare.venuemap

import com.amicly.alamofoursquare.common.scheduler.SchedulerProvider
import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.alamofoursquare.model.venue.VenueSearchResult
import com.amicly.alamofoursquare.venuesearch.VenueSearchContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class VenueMapPresenter @Inject constructor(private val view : VenueMapContract.View,
                                            private val fourSquareService: FourSquareService,
                                            private val schedulerProvider: SchedulerProvider):
        VenueMapContract.Presenter {

    init {
        fourSquareService.searchEvents("asdf")
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