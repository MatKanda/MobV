package com.example.myapp.network

import com.squareup.moshi.Json

data class PostBody(
    val collection: String = "bars",
    val database: String = "mobvapp",
    val dataSource: String = "Cluster0"){}