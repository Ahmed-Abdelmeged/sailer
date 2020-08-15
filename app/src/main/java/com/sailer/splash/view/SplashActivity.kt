package com.sailer.splash.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sailer.app.SailerApp
import com.sailer.navigation.AppCoordinator
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var coordinator: AppCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SailerApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        coordinator.activity = this
        coordinator.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.activity = null
    }
}