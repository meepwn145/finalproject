package com.macol_richard.animal.petcareplanner

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.macol_richard.animal.petcareplanner.Pet // Ensure to import the Pet class

class HealthTrackerActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PET_LIST = "extra_pet_list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_tracker)
        Log.d("HealthTrackerActivity", "Activity created") // Add this line

        // Retrieve the list of pets from the intent
        val petList = intent.getSerializableExtra(EXTRA_PET_LIST) as ArrayList<Pet>

        val btnBack: Button = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            finish() // This will finish the current activity and go back to the previous one.
        }
        // Display the list of pets and their health status
        val healthTrackerTextView: TextView = findViewById(R.id.tvHealthTracker)
        val healthTrackerText = buildHealthTrackerText(petList)
        healthTrackerTextView.text = healthTrackerText
    }

    private fun buildHealthTrackerText(petList: List<Pet>): String {
        val stringBuilder = StringBuilder()
        for (pet in petList) {
            stringBuilder.append("Pet: ${pet.name}\n")
            stringBuilder.append("Health Status: ${pet.healthStatus}\n\n")
        }
        return stringBuilder.toString()
    }
}
