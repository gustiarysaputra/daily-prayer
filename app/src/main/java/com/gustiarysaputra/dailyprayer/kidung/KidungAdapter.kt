package com.gustiarysaputra.dailyprayer.kidung

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.gustiarysaputra.dailyprayer.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class KidungAdapter (private val kidungList: ArrayList<KidungData>) :
    RecyclerView.Adapter<KidungAdapter.KidungViewHolder>() {
    private lateinit var kListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        kListener = listener
    }

    class KidungViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleVideo)
        val credit: TextView = itemView.findViewById(R.id.credit)
        var youTubePlayerView: YouTubePlayerView = itemView.findViewById(R.id.view_yt)

        init {
            itemView.setOnClickListener{

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KidungViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card_kidung, parent, false)
        return KidungViewHolder(itemView, kListener)
    }

    override fun onBindViewHolder(holder: KidungViewHolder, position: Int) {
        val currentItem = kidungList[position]
        holder.title.text = currentItem.title
        holder.credit.text = currentItem.credit
        holder.youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = currentItem.url
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })
    }

    override fun getItemCount(): Int {
        return kidungList.size
    }
}