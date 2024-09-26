package com.example.gis

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainActivity: AppCompatActivity() {
    private lateinit var treesSpeciesViewModel: TreesSpeciesViewModel
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        treesSpeciesViewModel = ViewModelProvider(this).get(TreesSpeciesViewModel::class.java)

        val btnGetSpecies = findViewById<Button>(R.id.btn_get_species)
        btnGetSpecies.setOnClickListener {

            val region = "Africa"// fetch from spinner
            val soilType = "Loamy"// fetch from spinner

            val speciesList = treesSpeciesViewModel.getTreeSpecies(region, soilType)

            //Display the species list to the user
            Toast.makeText(this, "Species : $speciesList", Toast.LENGTH_LONG).show()

        }

    }

}