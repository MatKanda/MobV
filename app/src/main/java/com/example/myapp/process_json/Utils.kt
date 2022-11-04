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

    fun getJsonData(jsonFileString: String):MutableList<Pub>{
        val allPubs:MutableList<Pub> = ArrayList()

        Log.i("data", jsonFileString)
        val gson = Gson()
        val listPubType = object : TypeToken<PubParent>() {}.type

        var pubs: PubParent = gson.fromJson(jsonFileString, listPubType)
//        pubs.elements.forEachIndexed { idx, pub -> }
//        pubs.elements.forEachIndexed { idx, pub ->
//            Log.i("data", "> Item $idx:\n$pub, name:${pub.tags.get("name")}")
//            if(pub.tags.get("name") != null){allPubs.add(pub)}}

        return allPubs
    }
}