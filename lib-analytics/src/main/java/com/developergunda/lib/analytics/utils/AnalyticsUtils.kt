package com.developergunda.lib.analytics.utils

import java.util.concurrent.TimeUnit

object AnalyticsUtils {
    fun getTimeDurationInSecBetweenNow(startTimeMillis: Long) =
        TimeUnit.SECONDS.convert(System.currentTimeMillis() - startTimeMillis, TimeUnit.MILLISECONDS)
}