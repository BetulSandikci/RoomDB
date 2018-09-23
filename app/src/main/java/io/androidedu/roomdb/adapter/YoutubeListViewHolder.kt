package io.androidedu.roomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.roomdb.R
import io.androidedu.roomdb.entity.YoutubeDTO


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:39          │
//└─────────────────────────────┘

class YoutubeListViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.adapter_item_youtube_video_list, parent, false)) {

    private val txtVideoName by lazy { itemView.findViewById<TextView>(R.id.txtVideoName) }


    fun bindTo(youtubeDTO: YoutubeDTO, onItemSelect: (youtubeDTO: YoutubeDTO) -> Unit) {

        txtVideoName.text = youtubeDTO.videoName

        itemView.setOnClickListener { onItemSelect }
    }
}