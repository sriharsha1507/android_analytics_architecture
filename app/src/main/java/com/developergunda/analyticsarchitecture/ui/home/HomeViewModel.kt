package com.developergunda.analyticsarchitecture.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developergunda.analyticsarchitecture.ui.home.analytics.HomeAnalyticsInteractor

class HomeViewModel @ViewModelInject constructor(
    private val analyticsInteractor: HomeAnalyticsInteractor
) : ViewModel() {

    fun onFirstTimeView() {
        analyticsInteractor.startTracking()
    }

    fun onViewExit() {
        analyticsInteractor.logHomeRead()
    }
}