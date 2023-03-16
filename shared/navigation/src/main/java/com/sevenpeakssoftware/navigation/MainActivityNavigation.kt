package com.sevenpeakssoftware.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.sevenpeakssoftware.core.navigationflows.MainActivityNavigationFlow
import javax.inject.Singleton

interface MainActivityNavigation {
    fun navigateToFlow(
        navController: NavController,
        flowMainActivity: MainActivityNavigationFlow,
        navOptions: NavOptions.Builder?
    )
}