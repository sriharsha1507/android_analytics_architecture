package com.developergunda.analyticsarchitecture.di

import android.content.Context
import com.developergunda.lib.analytics.AnalyticsManager
import com.developergunda.lib.analytics.AnalyticsService
import com.developergunda.lib.analytics.provider.DebugAnalyticsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideAnalyticsManager(@ApplicationContext context: Context): AnalyticsService {
        val analyticsManager = AnalyticsManager()
        analyticsManager.add(DebugAnalyticsService())
        analyticsManager.init(context)
        return analyticsManager
    }
}