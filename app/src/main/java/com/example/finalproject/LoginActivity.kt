package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. Прив'язуємо змінні до полів з твого нового XML
        val etName = findViewById<EditText>(R.id.etLoginName)
        val etEmail = findViewById<EditText>(R.id.etLoginEmail)
        val etPassword = findViewById<EditText>(R.id.etLoginPassword)
        val etPhone = findViewById<EditText>(R.id.etLoginPhone)
        val btnLogin = findViewById<Button>(R.id.btnLoginSubmit)

        btnLogin.setOnClickListener {
            // Отримуємо текст, який ти ввів зараз
            val inputName = etName.text.toString().trim()
            val inputEmail = etEmail.text.toString().trim()
            val inputPassword = etPassword.text.toString().trim()
            val inputPhone = etPhone.text.toString().trim()

            // 2. Дістаємо дані, які ми зберегли в RegisterActivity
            val sharedPrefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedName = sharedPrefs.getString("user_name", "")
            val savedEmail = sharedPrefs.getString("user_email", "")
            val savedPassword = sharedPrefs.getString("user_password", "")
            val savedPhone = sharedPrefs.getString("user_phone", "")

            // 3. Перевірка: чи все збігається?
            if (inputName == savedName && inputEmail == savedEmail &&
                inputPassword == savedPassword && inputPhone == savedPhone) {

                Toast.makeText(this, "Вхід успішний! Вітаємо у Dionysus Cellar", Toast.LENGTH_SHORT).show()

                // ПЕРЕХІД НА НОВИЙ ЕКРАН "МІЙ КАБІНЕТ"
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)

                // Закриваємо вікно входу, щоб користувач не повернувся сюди кнопкою "Назад"
                finish()

            } else {
                // Якщо дані введені неправильно
                Toast.makeText(this, "Помилка: Дані не збігаються з реєстрацією", Toast.LENGTH_LONG).show()
            }
        }
    }
}