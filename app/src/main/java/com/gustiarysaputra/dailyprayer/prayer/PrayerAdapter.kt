package com.gustiarysaputra.dailyprayer.prayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.gustiarysaputra.dailyprayer.R

class PrayerAdapter(private val prayerList: ArrayList<PrayerData>) : RecyclerView.Adapter<PrayerAdapter.PrayViewHolder>() {

    private lateinit var pListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        pListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card_prayer, parent, false)
        return PrayViewHolder(itemView, pListener)
    }

    override fun onBindViewHolder(holder: PrayViewHolder, position: Int) {
        val currentItem = prayerList[position]
        holder.title.text = currentItem.title
        holder.image.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return prayerList.size
    }

    class PrayViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.judul)
        val image: ShapeableImageView = itemView.findViewById(R.id.image_list)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

}