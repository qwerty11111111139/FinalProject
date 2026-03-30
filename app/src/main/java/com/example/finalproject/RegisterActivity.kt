package com.example.finalproject

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Знаходимо елементи по ID з XML
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnSubmit = findViewById<Button>(R.id.btnRegisterSubmit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            // Перевірка на заповнення
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Будь ласка, заповніть усі поля!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Збереження даних у внутрішню пам'ять
            val sharedPrefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString("user_name", name)
            editor.putString("user_email", email)
            editor.putString("user_phone", phone)
            editor.apply()

            Toast.makeText(this, "Вітаємо у Dionysus Cellar, $name!", Toast.LENGTH_LONG).show()

            // Закриваємо екран реєстрації
            finish()
        }
    }
}