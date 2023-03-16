package com.sevenpeakssoftware.dashboard.data.remote.api

import com.sevenpeakssoftware.dashboard.data.remote.models.ArtileContentDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("carlist")
    suspend fun getCarItems(): Response<ArtileContentDTO>
}