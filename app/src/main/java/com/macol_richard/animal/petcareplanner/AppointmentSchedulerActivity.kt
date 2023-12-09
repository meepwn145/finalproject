package com.macol_richard.animal.petcareplanner

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.macol_richard.animal.petcareplanner.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AppointmentSchedulerActivity : AppCompatActivity() {

    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_scheduler)

        // Button to schedule an appointment
        findViewById<Button>(R.id.btnScheduleAppointment).setOnClickListener {
            showDatePicker()
        }

        // Back button
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            navigateToPetProfile()
        }
    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                // Set the selected date to the calendar
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                // Show time picker after selecting the date
                showTimePicker()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }

    private fun showTimePicker() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                // Set the selected time to the calendar
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)

                // Display the selected date and time
                displaySelectedDateTime()

                // Disable the "SCHEDULE APPOINTMENT" button after scheduling
                findViewById<Button>(R.id.btnScheduleAppointment).isEnabled = false
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        )

        timePickerDialog.show()
    }

    private fun displaySelectedDateTime() {
        val dateFormat = SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm a", Locale.getDefault())
        val selectedDateTime = dateFormat.format(calendar.time)

        Toast.makeText(this, "Appointment scheduled for $selectedDateTime", Toast.LENGTH_LONG).show()
    }

    private fun navigateToPetProfile() {
        finish()
    }
}
