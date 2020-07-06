package com.developergunda.analyticsarchitecture.ui.dashboard.analytics

import com.developergunda.lib.analytics.AnalyticsConstants
import com.developergunda.lib.analytics.model.AnalyticsEvent

object DashboardEvents {
    class SubscribeEvent(
        timeBetweenClicks: Long
    ) : AnalyticsEvent(
        AnalyticsConstants.Events.ItemClicked.EVENT,
        mapOf(
            AnalyticsConstants.Events.ItemClicked.Params.BUTTON_NAME to AnalyticsConstants.Events.ItemClicked.ItemNames.SUBSCRIBE_BUTTON_NAME,
            AnalyticsConstants.Events.ItemClicked.Params.TIME_BETWEEN_CLICKS to timeBetweenClicks
        )
    )

    class BellIconEvent(
        timeBetweenClicks: Long
    ) : AnalyticsEvent(
        AnalyticsConstants.Events.ItemClicked.EVENT,
        mapOf(
            AnalyticsConstants.Events.ItemClicked.Params.BUTTON_NAME to AnalyticsConstants.Events.ItemClicked.ItemNames.BELL_ICON_FAB,
            AnalyticsConstants.Events.ItemClicked.Params.TIME_BETWEEN_CLICKS to timeBetweenClicks
        )
    )
}