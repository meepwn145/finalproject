package com.macol_richard.animal.petcareplanner

import java.util.*
import kotlin.collections.ArrayList
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID


class PetProfileActivity : AppCompatActivity() {

    private val petList = mutableListOf<Pet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_profile)
        val btnPetCareTips: Button = findViewById(R.id.btnPetCareTips)

        btnPetCareTips.setOnClickListener {
            val intent = Intent(this, PetCareTipsActivity::class.java)
            startActivity(intent)
        }

        val addPetButton: Button = findViewById(R.id.btnAddPet)
        addPetButton.setOnClickListener {
            // Open AddPetDetailsActivity to input pet details
            val intent = Intent(this, AddPetDetailsActivity::class.java)
            startActivityForResult(intent, ADD_PET_REQUEST_CODE)
        }

        findViewById<Button>(R.id.btnScheduleAppointment).setOnClickListener {
            navigateToAppointmentScheduler()
        }

        findViewById<Button>(R.id.btnReminderNotifications).setOnClickListener {
            // Open ReminderActivity to display reminder buttons
            startActivity(Intent(this, ReminderActivity::class.java))
        }
        findViewById<Button>(R.id.btnPetHealthTracker).setOnClickListener {
            // When the "Pet Health Tracker" button is clicked, navigate to HealthTrackerActivity
            navigateToHealthTracker()
        }
    }

    // Handle the result from AddPetDetailsActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_PET_REQUEST_CODE && resultCode == RESULT_OK) {
            val petName = data?.getStringExtra(AddPetDetailsActivity.EXTRA_PET_NAME)
            val petBreed = data?.getStringExtra(AddPetDetailsActivity.EXTRA_PET_BREED)
            val petAge = data?.getIntExtra(AddPetDetailsActivity.EXTRA_PET_AGE, 0)

            Toast.makeText(this, "Pet Added!\n Pet Name: $petName \n Pet Breed: $petBreed \n Pet Age: $petAge", Toast.LENGTH_LONG).show()
            // Automatically schedule an appointment after adding a pet
            navigateToAppointmentScheduler()

        }

    }


    private fun navigateToAppointmentScheduler() {
        val intent = Intent(this, AppointmentSchedulerActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHealthTracker() {
        val intent = Intent(this, HealthTrackerActivity::class.java)
        // Pass the list of pets to HealthTrackerActivity
        intent.putExtra(HealthTrackerActivity.EXTRA_PET_LIST, ArrayList(petList))
        startActivity(intent)
    }

    companion object {
        const val ADD_PET_REQUEST_CODE = 1
    }

}