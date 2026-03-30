package com.example.finalproject

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WineCardActivity : AppCompatActivity() {

    private lateinit var rvWine: RecyclerView
    private lateinit var adapter: WineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wine_card)

        // Ініціалізація RecyclerView
        rvWine = findViewById(R.id.rvMyRecipes)
        rvWine.layoutManager = LinearLayoutManager(this)

        // Твій уточнений преміальний список вин
        // Твій преміальний список вин з підключеними картинками
        val wineList = listOf(
            WineItem(1, "Romanée-Conti", "Франція. Найдорожче вино світу. Король королів.", R.drawable.wine_romanee),
            WineItem(2, "Pétrus", "Франція. Легендарне Мерло для колекціонерів.", R.drawable.wine_petrus),
            WineItem(3, "Screaming Eagle", "США. Культове каліфорнійське вино.", R.drawable.wine_eagle),
            WineItem(4, "Château Margaux", "Франція. Еталон елегантності та аристократизму.", R.drawable.wine_margaux),
            WineItem(5, "Domaine de la Romanée-Conti", "Бургундія. Вершина виноробства.", R.drawable.wine_domaine)
        )

        // Налаштування адаптера
        adapter = WineAdapter(wineList)
        rvWine.adapter = adapter

        // Кнопка повернення в "Мій Кабінет"
        val btnBack = findViewById<ImageView>(R.id.btnBackRecipes)
        btnBack?.setOnClickListener {
            finish()
        }
    }
}