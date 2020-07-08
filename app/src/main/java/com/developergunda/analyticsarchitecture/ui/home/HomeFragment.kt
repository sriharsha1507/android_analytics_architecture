package com.developergunda.analyticsarchitecture.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.developergunda.analyticsarchitecture.BuildConfig
import com.developergunda.analyticsarchitecture.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onFirstTimeView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onViewExit()
    }
}