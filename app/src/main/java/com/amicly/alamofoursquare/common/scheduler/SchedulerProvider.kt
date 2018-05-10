package com.amicly.alamofoursquare.common.scheduler

import io.reactivex.Scheduler

/**
 * Created by darrankelinske on 2/1/18.
 */

interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}