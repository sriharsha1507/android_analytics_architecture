package com.developergunda.lib.analytics

import android.content.Context
import com.developergunda.lib.analytics.model.AnalyticsEvent

class AnalyticsManager: AnalyticsService {

    private val _services: MutableList<AnalyticsService> = mutableListOf()

    override fun init(context: Context) {
        _services.forEach { it.init(context) }
    }

    override fun log(event: AnalyticsEvent) {
        _services.forEach { it.log(event) }
    }

    fun add(service: AnalyticsService) {
        _services.add(service)
    }
}