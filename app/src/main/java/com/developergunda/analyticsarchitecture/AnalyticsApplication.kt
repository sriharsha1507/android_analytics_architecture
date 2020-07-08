package com.developergunda.analyticsarchitecture

import android.app.Application
import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.analyticsarchitecture.analytics.provider.DebugAnalyticsService
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class AnalyticsApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogging()
    }

    private fun initLogging(){
        //Debug builds only
        Timber.plant(Timber.DebugTree())
    }
}