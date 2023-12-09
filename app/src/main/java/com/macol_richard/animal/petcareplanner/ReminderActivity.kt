package com.macol_richard.animal.petcareplanner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)
        val btnBack: Button = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            finish() // This will finish the current activity and go back to the previous one.
        }
        // Handle Reminder Notifications button click
        findViewById<Button>(R.id.btnReminderNotifications).setOnClickListener {
            showReminderButtons()
        }

        // Handle Feeding Reminder button click
        findViewById<Button>(R.id.btnFeedingReminder).setOnClickListener {
            startActivity(Intent(this, FeedingReminderActivity::class.java))
        }

        // Handle Vet Appointment Reminder button click
        findViewById<Button>(R.id.btnVetAppointmentReminder).setOnClickListener {
            startActivity(Intent(this, VetAppointmentReminderActivity::class.java))
        }

    }

    private fun showReminderButtons() {
        findViewById<Button>(R.id.btnFeedingReminder).visibility = View.VISIBLE
        findViewById<Button>(R.id.btnVetAppointmentReminder).visibility = View.VISIBLE
    }
}
