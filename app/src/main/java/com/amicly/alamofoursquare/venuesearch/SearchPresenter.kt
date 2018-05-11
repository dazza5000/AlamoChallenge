package com.amicly.alamofoursquare.venuesearch

import com.amicly.alamofoursquare.common.scheduler.SchedulerProvider
import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.alamofoursquare.model.venue.VenueSearchResult
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SearchPresenter @Inject constructor(private val view : SearchContract.View,
                                          private val fourSquareService: FourSquareService,
                                          private val schedulerProvider: SchedulerProvider) : SearchContract.Presenter {

    private val searchStringSubject = BehaviorSubject.create<String>()
    private val behaviorDisposable = CompositeDisposable()
    private val apiDisposable = CompositeDisposable()

    init {
        searchStringSubject
                .debounce(200, TimeUnit.MILLISECONDS)
                .filter({ charSequence -> charSequence.length > 1 })
                .subscribe(object : DisposableObserver<CharSequence>() {
                    override fun onStart() {
                        super.onStart()
                        behaviorDisposable.add(this)
                    }

                    override fun onNext(charSequence: CharSequence) {
                        performSearch(charSequence.toString())
                    }

                    override fun onError(e: Throwable) {
                        Timber.e(e)
                    }

                    override fun onComplete() {

                    }
                })
        searchStringSubject.onNext("Alamo Drafthouse")
    }

    private fun performSearch(searchQuery: String) {
        apiDisposable.clear()
        fourSquareService.searchEvents(searchQuery)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(object : DisposableSingleObserver<VenueSearchResult>() {
                    override fun onStart() {
                        super.onStart()
                        apiDisposable.add(this)
                    }

                    override fun onSuccess(searchResult: VenueSearchResult) {
                            searchResult.response?.venues?.run {
                                view.showVenues(this)
                            }
                    }

                    override fun onError(e: Throwable) {
                        Timber.e(e)
                        view.showNotification(e.toString())
                    }
                })
    }

    override fun searchQueryUpdated(newText: String) {
        searchStringSubject.onNext(newText)
    }

    override fun selectEvent(venue: Venue) {

    }
}