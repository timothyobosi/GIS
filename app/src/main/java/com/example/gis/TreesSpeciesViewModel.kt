package com.example.gis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class TreesSpeciesViewModel : ViewModel() {

    private val climateRepository = ClimateRepository()

    //function gets tree species based on region ans soil type
    fun getTreeSpecies(region: String, soilType:String){

        viewModelScope.launch(Dispatchers.IO) {
            try{
                val climateData = climateRepository.getClimateData(region)

            } catch (e: Exception){
                //Handle the error appropriately
                e.printStackTrace()
            }

        }

    }
}