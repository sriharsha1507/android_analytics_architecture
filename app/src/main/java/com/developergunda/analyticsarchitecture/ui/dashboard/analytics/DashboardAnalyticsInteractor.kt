package com.developergunda.analyticsarchitecture.ui.dashboard.analytics

import com.developergunda.lib.analytics.AnalyticsConstants
import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import com.developergunda.lib.analytics.utils.AnalyticsUtils
import javax.inject.Inject

class DashboardAnalyticsInteractor @Inject constructor(
    private val analyticsService: AnalyticsService
) {

    private var startTime: Long = 0

    fun startTrackingTime() {
        startTime = System.currentTimeMillis()
    }

    fun subscribeButtonClicked() {
        analyticsService.log(
            DashboardEvents.SubscribeEvent(
                AnalyticsUtils.getTimeDurationInSecBetweenNow(startTime)
            )
        )
        startTrackingTime()
    }

    fun bellIconFabClicked() {
        analyticsService.log(
            DashboardEvents.BellIconEvent(
                AnalyticsUtils.getTimeDurationInSecBetweenNow(startTime)
            )
        )
        startTrackingTime()
    }
}