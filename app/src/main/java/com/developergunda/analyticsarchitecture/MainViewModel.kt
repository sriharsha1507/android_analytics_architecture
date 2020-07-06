package com.developergunda.analyticsarchitecture

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.developergunda.analyticsarchitecture.analytics.MainAnalyticsInteractor

class MainViewModel @ViewModelInject constructor(private val analyticsInteractor: MainAnalyticsInteractor) :
    ViewModel() {

    fun destinationChanged(destinationId: Int) {
        analyticsInteractor.destinationChanged(destinationId)
    }
}