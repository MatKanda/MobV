package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.firstFragment) as NavHostFragment
        navController = navHostFragment.navController
//
    }

}