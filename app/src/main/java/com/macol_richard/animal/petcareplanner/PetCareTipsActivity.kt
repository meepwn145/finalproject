package com.macol_richard.animal.petcareplanner

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PetCareTipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_care_tips)

        val tvPetCareTips: TextView = findViewById(R.id.tvPetCareTips)
        val btnBack: Button = findViewById(R.id.btnBack)


        val petCareTips = """
            |Labrador Retriever:
            |Labradors thrive on regular exercise, so make sure to engage in daily activities like fetching to keep them happy and healthy.

            |German Shepherd:
            |German Shepherds are highly intelligent and trainable, so mental stimulation through obedience training is crucial for their well-being.

            |Poodle:
            |Poodles require regular grooming to maintain their curly coat, and mental stimulation through interactive play and toys is important for their intelligence.

            |Beagle:
            |Beagles have a keen sense of smell, so provide them with scent-based activities and walks to satisfy their natural instincts.

            |Bulldog:
            |Bulldogs can be prone to overheating due to their short snouts, so avoid vigorous exercise in hot weather and provide a cool, shaded environment.
        """.trimMargin()

        tvPetCareTips.text = petCareTips
        btnBack.setOnClickListener {
            finish() // This will finish the current activity and go back to the previous one.
        }

        // Implement logic to display pet care tips
        showToast("Pet care tips displayed!")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
