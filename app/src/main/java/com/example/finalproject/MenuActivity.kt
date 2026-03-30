package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // 1. ОСОБИСТІ ДАНІ
        val btnPersonalData = findViewById<TextView>(R.id.btnPersonalData)
        btnPersonalData.setOnClickListener {
            startActivity(Intent(this, PersonalDataActivity::class.java))
        }

        // 2. ІСТОРІЯ ЗАМОВЛЕНЬ
        val btnOrderHistory = findViewById<TextView>(R.id.btnOrderHistory)
        btnOrderHistory.setOnClickListener {
            startActivity(Intent(this, OrderHistoryActivity::class.java))
        }

        // 3. ВИННА КАРТА
        val btnWineCatalog = findViewById<TextView>(R.id.btnWineCatalog)
        btnWineCatalog.setOnClickListener {
            startActivity(Intent(this, WineDetailsActivity::class.java))
        }

        // 4. ОБРАНЕ
        val btnFavorites = findViewById<TextView>(R.id.btnFavorites)
        btnFavorites.setOnClickListener {
            // Поки що можна залишити порожнім або відкрити заглушку
        }

        // 5. НАЛАШТУВАННЯ (Наш пріоритет!)
        val btnSettings = findViewById<TextView>(R.id.btnSettings)
        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        // 6. ГОЛОВНИЙ ЕКРАН
        val btnMainScreen = findViewById<TextView>(R.id.btnMainScreen)
        btnMainScreen.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // 7. ВИЙТИ
        val btnLogout = findViewById<TextView>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("isAuthorized", false).apply()

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}