package com.example.practicumexam1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsView : AppCompatActivity() {
    private lateinit var detailsTextView: TextView
    private lateinit var averageTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize TextViews and Button
        detailsTextView = findViewById(R.id.detailsTextView)
        averageTextView = findViewById(R.id.averageTextView)
        backButton = findViewById(R.id.backBtn)

        // Retrieve temperature data from intent
        val days = intent.getStringArrayListExtra("day") ?: ArrayList()
        val minTemps = intent.getIntegerArrayListExtra("minimum temperature") ?: ArrayList()
        val maxTemps = intent.getIntegerArrayListExtra("maximum temperature") ?: ArrayList()
        val weatherConditions = intent.getStringArrayListExtra("weather conditions") ?: ArrayList()


        // Display details and calculate/display average temperature
        displayDetails(days, minTemps, maxTemps, weatherConditions)
        calculateAndDisplayAverage(minTemps, maxTemps)

        // Set click listener for back button
        backButton.setOnClickListener {
            finish() // Navigate back to the previous screen
        }
    }

    // Function to display temperature details
    private fun displayDetails(days: List<String>, minTemps: List<Int>, maxTemps: List<Int>, weatherConditions: List<String>) {
        val details = StringBuilder()
        for ((index, day) in days.withIndex()) {
            val minTemp = minTemps[index]
            val maxTemp = maxTemps[index]
            val condition = weatherConditions[index]
            details.append("Day: $day, Min Temp: $minTemp, Max Temp: $maxTemp, Condition: $condition\n")
        }
        detailsTextView.text = details.toString()
    }

    // Function to calculate and display average temperature
    private fun calculateAndDisplayAverage(minTemps: List<Int>, maxTemps: List<Int>) {
        if (minTemps.isNotEmpty() && maxTemps.isNotEmpty()) {
            val averageMinTemp = minTemps.average()
            val averageMaxTemp = maxTemps.average()
            averageTextView.text = "Average Min Temp: $averageMinTemp, Average Max Temp: $averageMaxTemp"
        } else {
            averageTextView.text = "No temperature data available"
        }
    }
}
