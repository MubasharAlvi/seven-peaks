package com.sevenpeakssoftware.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.sevenpeakssoftware.core.utils.navigate
import com.sevenpeakssoftware.core.navigationflows.MainActivityNavigationFlow
import javax.inject.Singleton

@Singleton
class MainActivityNavigationImpl : MainActivityNavigation {
    override fun navigateToFlow(
        navController: NavController,
        flowMainActivity: MainActivityNavigationFlow,
        navOptions: NavOptions.Builder?
    ) {
        when (flowMainActivity) {
            is MainActivityNavigationFlow.Dashboard -> {
                    navigate(
                        navController,
                        MainActivityNavigationDirections.actionToDashboard(),
                        navOptions
                    )
                }
            }
        }

    }
