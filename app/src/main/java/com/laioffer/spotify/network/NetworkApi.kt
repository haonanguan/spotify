package com.laioffer.spotify.network

import com.laioffer.spotify.datamodel.Section
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("feed")
    fun getHomeFeed(): Call<List<Section>>
}

//request: Get/Post/Put/Delete, Url (baseUrl + field), Response: return type
// json string -> List<Section>, need json converter in NetworkModule -> convert json to java class