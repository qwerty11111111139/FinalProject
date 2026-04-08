package com.example.finalproject

import android.content.Intent // Важливо для роботи з екранами
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WineAdapter(private val wineList: List<WineItem>) :
    RecyclerView.Adapter<WineAdapter.WineViewHolder>() {

    class WineViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ImageView = view.findViewById(R.id.ivWinePhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvWineTitle)
        val tvDesc: TextView = view.findViewById(R.id.tvWineDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wine, parent, false)
        return WineViewHolder(view)
    }

    override fun onBindViewHolder(holder: WineViewHolder, position: Int) {
        // 1. Отримуємо конкретне вино зі списку за його позицією
        val wine = wineList[position]

        // 2. Заповнюємо дані в елементи списку (щоб вони не були порожніми)
        holder.tvTitle.text = wine.name
        holder.tvDesc.text = wine.description
        holder.ivPhoto.setImageResource(wine.imageResId)

        // 3. Налаштовуємо клік для переходу на екран деталей
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, WineDetailsActivity::class.java)
            // Передаємо дані про конкретне вино
            intent.putExtra("wine_name", wine.name)
            intent.putExtra("wine_desc", wine.description)
            intent.putExtra("wine_image", wine.imageResId)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = wineList.size
}