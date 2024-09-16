package com.laioffer.spotify.network

import com.laioffer.spotify.datamodel.Section
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("feed")
    fun getHomeFeed(): Call<List<Section>>
}