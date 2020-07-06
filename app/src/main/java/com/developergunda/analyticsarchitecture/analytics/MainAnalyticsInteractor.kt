package com.developergunda.analyticsarchitecture.analytics

import com.developergunda.analyticsarchitecture.R
import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import javax.inject.Inject

class MainAnalyticsInteractor @Inject constructor(
    private val analyticsService: AnalyticsService
) {
    private var prevDestination: Int? = null

    fun destinationChanged(destinationId: Int) {
        if (destinationId == prevDestination) return

        prevDestination?.let {
            analyticsService.log(
                AppEvents.Navigated(
                    from = getNavigationDestination(it),
                    to = getNavigationDestination(destinationId)
                )
            )
        }
        prevDestination = destinationId
    }

    private fun getNavigationDestination(destination: Int): AppEvents.Navigated.NavigationSource =
        when (destination) {
            R.id.navigation_home -> AppEvents.Navigated.NavigationSource.HOME
            R.id.navigation_dashboard -> AppEvents.Navigated.NavigationSource.DASHBOARD
            R.id.navigation_notifications -> AppEvents.Navigated.NavigationSource.NOTIFICATIONS
            else -> AppEvents.Navigated.NavigationSource.NOTIFICATIONS
        }
}