package com.developergunda.lib.analytics

import android.content.Context
import com.developergunda.lib.analytics.model.AnalyticsEvent

interface AnalyticsService {
    fun init(context: Context)
    fun log(event: AnalyticsEvent)
}