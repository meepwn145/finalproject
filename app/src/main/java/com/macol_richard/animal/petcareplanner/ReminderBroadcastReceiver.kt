
package com.macol_richard.animal.petcareplanner

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReminderBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // Display a reminder notification here
        Toast.makeText(context, "Time to feed your pet!", Toast.LENGTH_SHORT).show()
    }
}
