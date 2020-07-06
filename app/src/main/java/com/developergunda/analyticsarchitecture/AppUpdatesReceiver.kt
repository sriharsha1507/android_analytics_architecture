package com.developergunda.analyticsarchitecture

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.developergunda.analyticsarchitecture.analytics.AppEvents
import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager
import dagger.hilt.internal.UnsafeCasts
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class AppUpdatesReceiver : BroadcastReceiver() {

    @Inject
    lateinit var analyticsService: AnalyticsService

    override fun onReceive(context: Context?, intent: Intent?) {
        //Workaround for hilt broadcast receiver injection -- Alpha mode : ( -- Still Hilt rocks
        val injector = BroadcastReceiverComponentManager.generatedComponent(context) as AppUpdatesReceiver_GeneratedInjector
        injector.injectAppUpdatesReceiver(UnsafeCasts.unsafeCast(this))

        intent?.let {
            if (it.action == Intent.ACTION_MY_PACKAGE_REPLACED) {
                analyticsService.log(AppEvents.AppUpdated())
            }
        }
    }
}