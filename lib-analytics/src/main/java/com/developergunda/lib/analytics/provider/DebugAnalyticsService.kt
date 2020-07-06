package com.developergunda.lib.analytics.provider

import android.content.Context
import com.developergunda.lib.analytics.AnalyticsService
import com.developergunda.lib.analytics.model.AnalyticsEvent
import timber.log.Timber

class DebugAnalyticsService : AnalyticsService {

    override fun init(context: Context) {
        //Nothing to initialize for Local Debug Analytics Service
        //We will be using Timber to log events which are being logged
    }

    override fun log(event: AnalyticsEvent) {
        Timber.d(" \n" +
                "Event sent \nEvent Name : ${event.eventName}, \nParams: ${event.params}")
    }
}