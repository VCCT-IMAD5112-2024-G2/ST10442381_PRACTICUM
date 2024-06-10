package com.example.practicumexam1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreen : AppCompatActivity() {

    private lateinit var dayEditText: EditText
    private lateinit var minEditText: EditText
    private lateinit var maxEditText: EditText
    private lateinit var weatherConditionEditText: EditText

    // ArrayLists to store temperature data
    private val days = ArrayList<String>()
    private val minTemps = ArrayList<Int>()
    private val maxTemps = ArrayList<Int>()
    private val weatherConditions = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize EditText fields
        dayEditText = findViewById(R.id.dayEditText)
        minEditText = findViewById(R.id.minEditText)
        maxEditText = findViewById(R.id.maxEditText)
        weatherConditionEditText = findViewById(R.id.conditionEditText)

        // Initialize buttons
        val clearButton: Button = findViewById(R.id.clearBtn)
        val viewDetails: Button = findViewById(R.id.viewBtn)
        val exitBtn: Button = findViewById(R.id.endBtn)
        val addBtn: Button = findViewById(R.id.addBtn)
        val averageBtn: Button = findViewById(R.id.averageBtn)

        // Set click listeners for buttons
        addBtn.setOnClickListener {
            addTemperature()
        }

        clearButton.setOnClickListener {
            clearData()
        }

        exitBtn.setOnClickListener {
            finish()
        }

        averageBtn.setOnClickListener {
            calculateAverageTemperature()
        }

        viewDetails.setOnClickListener { view ->
            // Start DetailsView activity and pass temperature data
            val intent = Intent(this, DetailsView::class.java)
            intent.putStringArrayListExtra("day", days)
            intent.putIntegerArrayListExtra("minimum temperature", minTemps)
            intent.putIntegerArrayListExtra("maximum temperature", maxTemps)
            intent.putStringArrayListExtra("weather conditions", weatherConditions)
            startActivity(intent)
        }


    }


    // Function to add temperature data
     private fun addTemperature() {
        val dayInput = dayEditText.text.toString()
        val minimumTemperature = minEditText.text.toString().toIntOrNull()
        val maximumTemperature = maxEditText.text.toString().toIntOrNull()
        val weatherConditionInput = weatherConditionEditText.text.toString()

        if (dayInput.isNotEmpty() && minimumTemperature != null && maximumTemperature != null && weatherConditionInput.isNotEmpty()) {
            // Add data to ArrayLists
            days.add(dayInput)
            minTemps.add(minimumTemperature)
            maxTemps.add(maximumTemperature)
            weatherConditions.add(weatherConditionInput)

            // Clear EditText fields
            dayEditText.text.clear()
            minEditText.text.clear()
            maxEditText.text.clear()
            weatherConditionEditText.text.clear()

            // Show success message
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
        } else {
            // Show error message if any field is empty or contains invalid data
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }


    // Function to clear all entered data
    private fun clearData() {
        days.clear()
        minTemps.clear()
        maxTemps.clear()
        weatherConditions.clear()
        dayEditText.text.clear()
        minEditText.text.clear()
        maxEditText.text.clear()
        weatherConditionEditText.text.clear()
    }

    private fun calculateAverageTemperature() {
        if (minTemps.isNotEmpty() && maxTemps.isNotEmpty()) {
            val averageMinTemp = minTemps.average()
            val averageMaxTemp = maxTemps.average()

            Toast.makeText(this, "Average Min Temp: $averageMinTemp, Average Max Temp: $averageMaxTemp", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "No temperature data available", Toast.LENGTH_SHORT).show()
        }
    }
}