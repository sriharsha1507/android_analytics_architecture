package com.developergunda.analyticsarchitecture.ui.home.analytics

import com.developergunda.lib.analytics.AnalyticsConstants
import com.developergunda.lib.analytics.model.AnalyticsEvent

object HomeEvents {
    class HomeReadEvent(
        timeInMillis: Long
    ): AnalyticsEvent(
        AnalyticsConstants.Events.HomeRead.EVENT,
        mapOf(
            AnalyticsConstants.Events.HomeRead.Params.TIME_SPENT to timeInMillis
        )
    )
}