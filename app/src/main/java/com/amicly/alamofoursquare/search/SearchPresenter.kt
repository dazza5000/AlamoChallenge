package com.amicly.alamofoursquare.search

import com.amicly.alamofoursquare.common.scheduler.SchedulerProvider
import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.amicly.alamofoursquare.model.FourSquareVenueSearchResult
import com.amicly.alamofoursquare.model.Venue
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
    }

    private fun performSearch(searchQuery: String) {
        apiDisposable.clear()
        fourSquareService.searchEvents(searchQuery)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(object : DisposableSingleObserver<FourSquareVenueSearchResult>() {
                    override fun onStart() {
                        super.onStart()
                        apiDisposable.add(this)
                    }

                    override fun onSuccess(searchResult: FourSquareVenueSearchResult) {
                            searchResult.response?.venues?.apply {
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