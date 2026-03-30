package com.example.finalproject

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_personal_data)


        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnSave = findViewById<Button>(R.id.btnSaveData)


        val sharedPrefs = getSharedPreferences("DionysusPrefs", Context.MODE_PRIVATE)
        etLastName.setText(sharedPrefs.getString("user_last_name", ""))
        etFirstName.setText(sharedPrefs.getString("user_first_name", ""))
        etPhone.setText(sharedPrefs.getString("user_phone", ""))


        btnSave.setOnClickListener {
            val lastName = etLastName.text.toString().trim()
            val firstName = etFirstName.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            if (lastName.isNotEmpty() && firstName.isNotEmpty() && phone.isNotEmpty()) {

                sharedPrefs.edit().apply {
                    putString("user_last_name", lastName)
                    putString("user_first_name", firstName)
                    putString("user_phone", phone)
                    apply()
                }

                Toast.makeText(this, "Дані успішно оновлено ✨", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Будь ласка, заповніть усі поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}