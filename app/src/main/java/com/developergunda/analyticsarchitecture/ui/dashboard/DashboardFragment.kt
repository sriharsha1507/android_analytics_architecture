package com.developergunda.analyticsarchitecture.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.developergunda.analyticsarchitecture.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashboard.*

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startTrackingSession()
        viewModel.text.observe(viewLifecycleOwner, Observer {
            text_dashboard.text = it
        })

        subscribeButton.setOnClickListener {
            viewModel.onSubscribe()
        }

        fab.setOnClickListener {
            viewModel.onBell()
        }
    }
}