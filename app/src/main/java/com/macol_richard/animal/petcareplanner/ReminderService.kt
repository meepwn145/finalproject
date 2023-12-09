package com.macol_richard.animal.petcareplanner
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class ReminderService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        showToast("Reminder notification!")
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}