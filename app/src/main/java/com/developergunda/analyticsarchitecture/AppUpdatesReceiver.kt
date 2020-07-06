package com.developergunda.analyticsarchitecture

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.developergunda.analyticsarchitecture.analytics.AppEvents
import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import timber.log.Timber
import javax.inject.Inject

class AppUpdatesReceiver @Inject constructor(private val analyticsService: AnalyticsService) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (it.action == Intent.ACTION_MY_PACKAGE_REPLACED) {
                analyticsService.log(AppEvents.AppUpdated())
            }
        }
    }
}