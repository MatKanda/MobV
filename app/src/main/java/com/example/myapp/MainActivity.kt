package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.airbnb.lottie.LottieAnimationView
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.process_json.MySingleton
import com.example.myapp.process_json.Pub
import com.example.myapp.process_json.PubParent
import com.example.myapp.process_json.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    var allPubs:MutableList<Pub> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val utils = Utils()
        val jsonFileName = "pubs.json"
        val jsonFileString = utils.getJsonDataFromAsset(applicationContext, jsonFileName)

        if (jsonFileString != null) {
            MySingleton.allPubs = utils.getJsonData(jsonFileString)
        }
        System.out.println()


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}