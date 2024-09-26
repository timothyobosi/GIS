package com.example.gis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClimateRepository {
    private val apiService: ClimateAPiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ClimateAPiService::class.java)





    }

    // suspend function to fetch climate data from the API
    suspend fun getClimateData(region: String) : ClimateDataResponse{
        return apiService.getClimateData(region)
    }
}