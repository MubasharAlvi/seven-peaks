package com.sevenpeakssoftware.mubasharalvi.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import com.sevenpeakssoftware.core.navigationflows.MainActivityNavigationFlow
import com.sevenpeakssoftware.core.ui.activityviewmodel.LaunchActivityEvents
import com.sevenpeakssoftware.core.ui.activityviewmodel.MainActivityViewModel
import com.sevenpeakssoftware.core.utils.collectWhenStarted
//import com.sevenpeakssoftware.core.navigationflows.MainActivityNavigationFlow
//import com.sevenpeakssoftware.core.ui.activityviewmodel.LaunchActivityEvents
//import com.sevenpeakssoftware.core.ui.activityviewmodel.MainActivityViewModel
//import com.sevenpeakssoftware.core.utils.collectWhenStarted
import com.sevenpeakssoftware.mubasharalvi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {
    private val activityViewModel by activityViewModels<MainActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToDashboard()
        }, 2000)
    }

    private fun navigateToDashboard() {

        collectWhenStarted {
            activityViewModel.activityIntents.send(
                LaunchActivityEvents.NavigateToFlow(
                    MainActivityNavigationFlow.Dashboard,
                    NavOptions.Builder().setPopUpTo(R.id.splashFragment, true)
                )
            )
        }
    }
}