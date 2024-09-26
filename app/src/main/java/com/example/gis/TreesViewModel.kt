package com.example.gis

import androidx.lifecycle.ViewModel

class TreesViewModel : ViewModel() {

    //function gets tree species based on region ans soil type
    fun getTreeSpecies(region: String, soilType:String):List<String>{

        //Simulating the retrieval f species
        return listOf("Acacia","Baobab","Moringa")

    }
}