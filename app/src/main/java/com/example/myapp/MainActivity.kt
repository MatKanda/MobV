package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startButton)
        val stopButton: Button = findViewById(R.id.stopButton)
        val animation: LottieAnimationView = findViewById(R.id.animationView)
        startButton.setOnClickListener {
            animation.playAnimation()
        }
        stopButton.setOnClickListener {
            animation.cancelAnimation()
        }
    }

}