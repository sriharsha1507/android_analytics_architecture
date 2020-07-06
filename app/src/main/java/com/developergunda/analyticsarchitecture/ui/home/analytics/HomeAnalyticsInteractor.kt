package com.developergunda.analyticsarchitecture.ui.home.analytics

import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import com.developergunda.lib.analytics.utils.AnalyticsUtils
import javax.inject.Inject

class HomeAnalyticsInteractor @Inject constructor(
    private val analyticsService: AnalyticsService
) {

    private var startTime:Long = 0L

    fun startTracking(){
        startTime = System.currentTimeMillis()
    }

    fun logHomeRead(){
        analyticsService.log(
            HomeEvents.HomeReadEvent(
                AnalyticsUtils.getTimeDurationInSecBetweenNow(startTime)
            )
        )
        startTracking()
    }
}