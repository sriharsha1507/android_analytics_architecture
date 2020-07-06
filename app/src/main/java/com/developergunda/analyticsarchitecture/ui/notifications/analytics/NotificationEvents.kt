package com.developergunda.analyticsarchitecture.ui.notifications.analytics

import com.developergunda.lib.analytics.AnalyticsConstants
import com.developergunda.lib.analytics.model.AnalyticsEvent

object NotificationEvents {
    class ToggleEvent(value: Boolean):
            AnalyticsEvent(
                AnalyticsConstants.Events.NotificationsChanged.EVENT,
                mapOf(
                    AnalyticsConstants.Events.NotificationsChanged.Params.SETTING_STATE to value
                )
            )
}