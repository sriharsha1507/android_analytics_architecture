package com.developergunda.analyticsarchitecture.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developergunda.analyticsarchitecture.ui.dashboard.analytics.DashboardAnalyticsInteractor

class DashboardViewModel @ViewModelInject constructor(
    private val analyticsInteractor: DashboardAnalyticsInteractor
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun startTrackingSession(){
        analyticsInteractor.startTrackingTime()
    }

    fun onSubscribe(){
        analyticsInteractor.subscribeButtonClicked()
    }

    fun onBell(){
        analyticsInteractor.bellIconFabClicked()
    }
}