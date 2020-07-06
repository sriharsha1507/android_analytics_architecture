package com.developergunda.lib.analytics.model

open class AnalyticsEvent(
    val eventName: String,
    val params: Map<String, Any?>? = null
)