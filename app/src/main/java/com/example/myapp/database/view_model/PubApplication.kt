package com.example.myapp.database.view_model

import android.app.Application
import com.example.myapp.database.PubRepository
import com.example.myapp.database.PubRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PubApplication: Application() {
//    val applicationScope = CoroutineScope(SupervisorJob())

    val database: PubRoomDatabase by lazy { PubRoomDatabase.getDatabase(this) }
//    val repository by lazy { PubRepository(database.pubTableDao()) }
}