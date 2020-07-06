package com.developergunda.analyticsarchitecture.analytics

import com.developergunda.lib.analytics.AnalyticsConstants
import com.developergunda.lib.analytics.model.AnalyticsEvent

object AppEvents {
    class Navigated(
        from: NavigationSource,
        to: NavigationSource
    ) : AnalyticsEvent(
        AnalyticsConstants.Events.Navigated.EVENT,
        mapOf(
            AnalyticsConstants.Events.Navigated.Params.FROM to from.toConstant(),
            AnalyticsConstants.Events.Navigated.Params.TO to to.toConstant()
        )
    ) {
        enum class NavigationSource {
            HOME,
            DASHBOARD,
            NOTIFICATIONS;


            fun toConstant(): String =
                when (this) {
                    HOME -> AnalyticsConstants.Events.Navigated.NavigationSources.HOME
                    DASHBOARD -> AnalyticsConstants.Events.Navigated.NavigationSources.DASHBOARD
                    NOTIFICATIONS -> AnalyticsConstants.Events.Navigated.NavigationSources.NOTIFICATIONS
                }
        }
    }

    class AppUpdated() : AnalyticsEvent(AnalyticsConstants.Events.AppUpdated.EVENT)
}