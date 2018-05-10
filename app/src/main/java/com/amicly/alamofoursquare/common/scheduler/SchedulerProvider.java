package com.amicly.alamofoursquare.common.scheduler;

import io.reactivex.Scheduler;

/**
 * Created by darrankelinske on 2/1/18.
 */

public interface SchedulerProvider {

    Scheduler mainThread();

    Scheduler computation();

    Scheduler io();
}