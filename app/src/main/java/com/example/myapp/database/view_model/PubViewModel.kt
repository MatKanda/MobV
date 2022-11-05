package com.example.myapp.database.view_model

import android.content.ClipData
import android.util.Log
import androidx.lifecycle.*
import com.example.myapp.database.PubTable
import com.example.myapp.database.PubTableDao
import com.example.myapp.network.PostBody
import com.example.myapp.network.PubsApi
import com.example.myapp.network.RetrofitHelper
import com.example.myapp.process_json.MySingleton
import com.example.myapp.process_json.MySingleton.allPubs
import com.example.myapp.process_json.Pub
import com.example.myapp.process_json.PubParent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class PubViewModel(private val pubTableDao: PubTableDao) : ViewModel() {
    // Cache all items form the database using LiveData.
    val allPubs: LiveData<List<PubTable>> = pubTableDao.getItems().asLiveData()

    init {
        loadDataFromAPI()
    }
    /**
     * Launching a new coroutine to update an item in a non-blocking way
     */
    private fun updateItem(pubTable: PubTable) {
        viewModelScope.launch {
            pubTableDao.update(pubTable)
        }
    }
    private fun insertItem(pubTable: PubTable) {
        viewModelScope.launch {
            pubTableDao.insert(pubTable)
        }
    }

    private fun deleteAll(){
        viewModelScope.launch {
            pubTableDao.deleteAll()
        }
    }

    //-------------------------------------------------------------------------------------------------------------------//
    fun addNewItem(pubName: String, latitude: String, longitude: String,website: String ="www", opening_hours: String="PO-NE",outdoor_seating: String="Asi ne") {
        val newPub = getNewItemEntry(pubName, latitude, longitude,website, opening_hours,outdoor_seating)
        insertItem(newPub)
    }
    private fun getNewItemEntry(pubName: String, latitude: String, longitude: String,website: String, opening_hours: String,outdoor_seating: String): PubTable {
        return PubTable(
            pubName = pubName,
            latitude = latitude,
            longitude = longitude,
            website = website,
            opening_hours = opening_hours,
            outdoor_Seating = outdoor_seating
        )
    }

    fun deleteAllPubs(){
        deleteAll()
    }


    private fun loadDataFromAPI() {
        viewModelScope.launch{
            Log.i("abascasc: ", "Som v couroutine")

            val pubsApi = RetrofitHelper.getInstance().create(PubsApi::class.java)

            val result = pubsApi.getAllPubs(PostBody())
            result.body()?.documents?.forEach{ pub ->
                pub.tags.get("name")?.let {
                    addNewItem(
                        it,
                        pub.lat,
                        pub.lon,
//                        pub.tags.get("website")!!,
//                        pub.tags.get("opening_hours")!!,
//                        pub.tags.get("outdoor_seating")!!
                    )
                }
            }
//                addNewItem("asasa","aaaa", "aaaa", "aaaa", "aaaa", "aaaa" )
//            deleteAllPubs()

            Log.i("abascasc: ", "Som na konci couroutine")

        }
    }
}

/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class PubViewModelFactory(private val pubTableDao: PubTableDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PubViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PubViewModel(pubTableDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}