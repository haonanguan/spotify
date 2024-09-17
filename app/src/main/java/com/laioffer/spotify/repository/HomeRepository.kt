package com.laioffer.spotify.repository

import com.laioffer.spotify.datamodel.Section
import com.laioffer.spotify.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val networkApi: NetworkApi) {

    //suspend can only called inside coroutine
    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        networkApi.getHomeFeed().execute().body() ?: listOf()
    }
}