package com.example.finalproject

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WineCardActivity : AppCompatActivity() {

    private lateinit var rvWine: RecyclerView
    private lateinit var adapter: WineAdapter

    // Переносимо список сюди, щоб він був доступний у всьому класі
    private val wineList = listOf(
        WineItem(1, "Romanée-Conti", "Франція. Найдорожче вино світу.", R.drawable.wine_romanee, "ТЕМНІ ШЕДЕВРИ"),
        WineItem(2, "Pétrus", "Франція. Легендарне Мерло.", R.drawable.wine_petrus, "ТЕМНІ ШЕДЕВРИ"),
        WineItem(3, "Screaming Eagle", "США. Культове вино.", R.drawable.wine_eagle, "ТЕМНІ ШЕДЕВРИ"),
        WineItem(4, "Château Margaux", "Франція. Еталон елегантності.", R.drawable.wine_margaux, "ТЕМНІ ШЕДЕВРИ"),
        WineItem(9, "Louis Roederer Cristal", "Франція. Престижне шампанське.", R.drawable.wine_cristal, "ЗОРЯНИЙ ПИЛ"),
        WineItem(6, "Armand de Brignac", "Франція. Знаменитий «Туз Пік».", R.drawable.wine_armand, "ЗОРЯНИЙ ПИЛ"),
        WineItem(10, "Bollinger Vieilles Vignes", "Франція. Унікальне шампанське.", R.drawable.wine_bollinger, "ЗОРЯНИЙ ПИЛ"),
        WineItem(8, "Quinta do Noval Nacional", "Португалія. Величний портвейн.", R.drawable.wine_noval, "БОЖЕСТВЕННИЙ НЕКТАР")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wine_card)

        // 1. Ініціалізація RecyclerView
        rvWine = findViewById(R.id.rvMyRecipes)
        rvWine.layoutManager = LinearLayoutManager(this)

        // 2. Налаштування адаптера зі стартовим списком
        adapter = WineAdapter(wineList)
        rvWine.adapter = adapter

        // 3. Логіка кнопки КАТЕГОРІЇ
        val btnCategories = findViewById<Button>(R.id.btnWineCategories)
        val categories = arrayOf("Усі", "ЗОРЯНИЙ ПИЛ", "ТЕМНІ ШЕДЕВРИ", "БОЖЕСТВЕННИЙ НЕКТАР")

        btnCategories.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Оберіть колекцію")
            builder.setItems(categories) { _, which ->
                val selected = categories[which]
                btnCategories.text = selected

                val filteredList = if (selected == "Усі") {
                    wineList
                } else {
                    wineList.filter { it.category == selected }
                }

                // Оновлюємо список через новий адаптер
                rvWine.adapter = WineAdapter(filteredList)
            }
            builder.show()
        }

        // 4. Кнопка повернення
        val btnBack = findViewById<ImageView>(R.id.btnBackRecipes)
        btnBack?.setOnClickListener { finish() }
    }
}