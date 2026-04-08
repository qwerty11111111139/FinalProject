package com.example.finalproject

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PersonalDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        // Знаходимо елементи
        val etName = findViewById<EditText>(R.id.etProfileName)
        val etSurname = findViewById<EditText>(R.id.etProfileSurname)
        val etEmail = findViewById<EditText>(R.id.etProfileEmail)
        val etPhone = findViewById<EditText>(R.id.etProfilePhone)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        // Завантажуємо дані, які ти вводив при реєстрації
        val sharedPrefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        etName.setText(sharedPrefs.getString("user_name", "Не вказано"))
        etSurname.setText(sharedPrefs.getString("user_surname", "Не вказано"))
        etEmail.setText(sharedPrefs.getString("user_email", "Не вказано"))
        etPhone.setText(sharedPrefs.getString("user_phone", "Не вказано"))

        // Кнопка назад
        btnBack.setOnClickListener {
            finish()
        }
    }
}