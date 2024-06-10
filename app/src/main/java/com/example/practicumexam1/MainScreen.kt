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

        dayEditText = findViewById(R.id.dayEditText)
        minEditText = findViewById(R.id.minEditText)
        maxEditText = findViewById(R.id.maxEditText)
        weatherConditionEditText = findViewById(R.id.conditionEditText)

        val clearButton: Button = findViewById(R.id.clearBtn)
        val viewDetails: Button = findViewById(R.id.viewBtn)
        val exitBtn: Button = findViewById(R.id.endBtn)
        val addBtn: Button = findViewById(R.id.addBtn)
        val averageBtn: Button = findViewById(R.id.averageBtn)

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
            val intent = Intent(this, DetailsView::class.java)
            intent.putStringArrayListExtra("day", days)
            intent.putIntegerArrayListExtra("minimum temperature", minTemps)
            intent.putIntegerArrayListExtra("maximum temperature", maxTemps)
            intent.putStringArrayListExtra("weather conditions", weatherConditions)
            startActivity(intent)
        }


    }

    private fun addTemperature() {
        val dayInput = dayEditText.text.toString()
        val minimumTemperature = minEditText.text.toString().toIntOrNull()
        val maximumTemperature = maxEditText.text.toString().toIntOrNull()
        val weatherConditionInput = weatherConditionEditText.text.toString()

        if (dayInput.isNotEmpty() && minimumTemperature != null && maximumTemperature != null && weatherConditionInput.isNotEmpty()) {
            days.add(dayInput)
            minTemps.add(minimumTemperature)
            maxTemps.add(maximumTemperature)
            weatherConditions.add(weatherConditionInput)

            dayEditText.text.clear()
            minEditText.text.clear()
            maxEditText.text.clear()
            weatherConditionEditText.text.clear()

            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

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