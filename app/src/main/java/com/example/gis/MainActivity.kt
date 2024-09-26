package com.example.gis

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity: AppCompatActivity() {
    private lateinit var treesSpeciesViewModel: TreesSpeciesViewModel
    private lateinit var regionSpinner: Spinner
    private lateinit var soilTypeSpinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        treesSpeciesViewModel = ViewModelProvider(this).get(TreesSpeciesViewModel::class.java)

        //Initialize Spinners
        regionSpinner=findViewById(R.id.spinner_region)
        soilTypeSpinner=findViewById(R.id.spinner_soil_type)


        //Set up the spinners with data
        setupSpinners()


        // button Onclick Listener
        val btnGetSpecies = findViewById<Button>(R.id.btn_get_species)
        btnGetSpecies.setOnClickListener {

            //fetch selected region ans soil type from spinners
            val region = "Africa"// fetch from spinner
            val soilType = "Loamy"// fetch from spinner

            //call ViewModel to fetch tree species
            treesSpeciesViewModel.getTreeSpecies(region, soilType)

            //For nw we just show a placeholder
            Toast.makeText(this, "Fetching tree species...", Toast.LENGTH_LONG).show()

        }

    }

    //Function to populate the spinners with data
    private fun setupSpinners(){

        //Data for region spinner
        val regions = listOf("Africa","Asia","Europe","North America")
        val regionAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, regions)
        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        regionSpinner.adapter = regionAdapter

        //Data for soil type spinner
        val soilTypes = listOf("Loamy","Sandy","Clay","Peaty")
        val soilTypeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, soilTypes)
        soilTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        soilTypeSpinner.adapter = soilTypeAdapter
    }

}