package com.sevenpeakssoftware.core.ui.activityviewmodel

import androidx.navigation.NavOptions
import com.sevenpeakssoftware.core.navigationflows.MainActivityNavigationFlow

sealed class LaunchActivityEvents {
    data class NavigateToFlow(
        val destination: MainActivityNavigationFlow,
        val navOptions: NavOptions.Builder?
    ) : LaunchActivityEvents()
}