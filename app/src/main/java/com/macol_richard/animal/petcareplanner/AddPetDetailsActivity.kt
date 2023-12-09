package com.macol_richard.animal.petcareplanner
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast

class AddPetDetailsActivity : AppCompatActivity() {

    private lateinit var etPetName: TextInputEditText
    private lateinit var etPetBreed: TextInputEditText
    private lateinit var etPetAge: TextInputEditText
    private lateinit var btnSave: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet_details)

        etPetName = findViewById(R.id.etPetName)
        etPetBreed = findViewById(R.id.etPetBreed)
        etPetAge = findViewById(R.id.etPetAge)
        btnSave = findViewById(R.id.btnSave)
        btnBack = findViewById(R.id.btnBack)  // Move the initialization here

        btnSave.setOnClickListener {
            savePetDetails()
        }

        btnBack.setOnClickListener {
            // Handle back action
            onBackPressed()
        }
    }

    private fun savePetDetails() {
        val petName = etPetName.text.toString()
        val petBreed = etPetBreed.text.toString()
        val petAge = etPetAge.text.toString().toIntOrNull() ?: 0

        if (petName.isNotEmpty() && petBreed.isNotEmpty() && petAge > 0) {
            val resultIntent = Intent().apply {
                putExtra(EXTRA_PET_NAME, petName)
                putExtra(EXTRA_PET_BREED, petBreed)
                putExtra(EXTRA_PET_AGE, petAge)
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            showToast("Please fill in all fields.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val EXTRA_PET_NAME = "extra_pet_name"
        const val EXTRA_PET_BREED = "extra_pet_breed"
        const val EXTRA_PET_AGE = "extra_pet_age"
    }

}