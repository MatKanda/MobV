package com.example.myapp.process_json

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.util.ArrayList

class Utils (){
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getJsonData(jsonFileString: String): MutableList<String> {
        val allPubs:MutableList<String> = ArrayList()

        Log.i("data", jsonFileString)
        val gson = Gson()
        val listPubType = object : TypeToken<PubParent>() {}.type

        var pubs: PubParent = gson.fromJson(jsonFileString, listPubType)
//        pubs.elements.forEachIndexed { idx, pub -> Log.i("data", "> Item $idx:\n$pub, name:${pub.tags.get("name")}") }
        pubs.elements.forEachIndexed {
                _, pub -> Log.i("data", ">\n, name:${pub.tags["name"]}, lat: ${pub.lat}, lng: ${pub.lon}")
            pub.tags["name"]?.let { allPubs.add(it) }
        }
        System.out.println()

        return allPubs
    }
}