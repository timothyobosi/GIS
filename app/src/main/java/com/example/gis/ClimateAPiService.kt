package com.example.gis

import retrofit2.http.GET
import retrofit2.http.Query

interface ClimateAPiService {
    @GET("climate/data")
    suspend fun getClimateData(@Query("region")region: String): ClimateDataResponse
}