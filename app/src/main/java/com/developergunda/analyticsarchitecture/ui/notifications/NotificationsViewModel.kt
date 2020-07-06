package com.developergunda.analyticsarchitecture.ui.notifications

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developergunda.analyticsarchitecture.ui.notifications.analytics.NotificationAnalyticsInteractor

class NotificationsViewModel @ViewModelInject constructor(
    private val analyticsInteractor: NotificationAnalyticsInteractor
) : ViewModel() {
    fun onNotificationsChange(value: Boolean){
        analyticsInteractor.onToggle(value)
    }
}