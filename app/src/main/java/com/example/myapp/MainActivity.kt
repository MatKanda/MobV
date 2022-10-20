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
import com.example.myapp.process_json.Pub
import com.example.myapp.process_json.PubParent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.myapp.process_json.getJsonDataFromAsset

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "pubs.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

        val gson = Gson()
        val listPubType = object : TypeToken<PubParent>() {}.type

        var pubs: PubParent = gson.fromJson(jsonFileString, listPubType)
//        pubs.elements.forEachIndexed { idx, pub -> Log.i("data", "> Item $idx:\n$pub, name:${pub.tags.get("name")}") }
        pubs.elements.forEachIndexed { idx, pub -> Log.i("data", "> Item $idx:\n, name:${pub.tags.get("name")}, lat: ${pub.lat}, lng: ${pub.lon}") }

        System.out.println()

        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}