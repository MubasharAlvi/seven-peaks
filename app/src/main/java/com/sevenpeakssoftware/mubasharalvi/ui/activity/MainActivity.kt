package com.sevenpeakssoftware.mubasharalvi.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sevenpeakssoftware.core.ui.activityviewmodel.LaunchActivityEvents
import com.sevenpeakssoftware.core.ui.activityviewmodel.MainActivityViewModel
import com.sevenpeakssoftware.mubasharalvi.R
import com.sevenpeakssoftware.navigation.MainActivityNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModels<MainActivityViewModel>()

    @Inject
    lateinit var launchActivityNavigation: MainActivityNavigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        init()
        initObservers()
    }

    private fun init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.event.collect { events ->
                    when (events) {
                        is LaunchActivityEvents.NavigateToFlow -> {
                            launchActivityNavigation.navigateToFlow(
                                navController, events.destination, events.navOptions
                            )
                        }
                    }
                }
            }
        }
    }
}