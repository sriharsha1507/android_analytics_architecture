package com.developergunda.analyticsarchitecture.ui.notifications.analytics

import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import javax.inject.Inject

class NotificationAnalyticsInteractor @Inject constructor(private val analyticsService: AnalyticsService) {
    fun onToggle(value: Boolean){
        analyticsService.log(
            NotificationEvents.ToggleEvent(value)
        )
    }
}