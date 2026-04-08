package com.example.finalproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WineDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wine_details)

        // Отримуємо об'єкт рецепта, який ми передали через Intent
        val recipe = intent.getSerializableExtra("recipe") as? RecipeItem

        recipe?.let {
            findViewById<TextView>(R.id.tvRecipeTitle).text = it.title
            // Тут додай решту полів (інгредієнти, кроки тощо)
        }

        findViewById<ImageView>(R.id.btnBack).setOnClickListener { finish() }
    }
}