package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etRegName)
        val etSurname = findViewById<EditText>(R.id.etRegSurname)
        val etEmail = findViewById<EditText>(R.id.etRegEmail)
        val etPhone = findViewById<EditText>(R.id.etRegPhone)
        val etPassword = findViewById<EditText>(R.id.etRegPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegisterSubmit)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val surname = etSurname.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Зберігаємо дані в пам'ять пристрою
                val sharedPrefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPrefs.edit()
                editor.putString("user_name", name)
                editor.putString("user_surname", surname)
                editor.putString("user_email", email)
                editor.putString("user_phone", phone)
                editor.putString("user_password", password)
                editor.apply()

                Toast.makeText(this, "Реєстрація успішна!", Toast.LENGTH_SHORT).show()
                finish() // Повертаємось на екран входу
            } else {
                Toast.makeText(this, "Заповніть основні поля!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}