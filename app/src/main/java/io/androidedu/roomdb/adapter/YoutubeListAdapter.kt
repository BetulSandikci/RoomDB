package io.androidedu.roomdb.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.roomdb.entity.YoutubeDTO
import java.util.*


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:39          │
//└─────────────────────────────┘

class YoutubeListAdapter(val onItemSelect: (youtubeDTO: YoutubeDTO) -> Unit)
    : RecyclerView.Adapter<YoutubeListViewHolder>() {

    private var youtubeList: List<YoutubeDTO> = Collections.emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeListViewHolder = YoutubeListViewHolder(parent)

    override fun getItemCount(): Int = youtubeList.size

    override fun onBindViewHolder(holder: YoutubeListViewHolder, position: Int) {

        holder.bindTo(youtubeList[position]) { onItemSelect(it) }
    }

    fun setNewYoutubeList(newYoutubeList: List<YoutubeDTO>) {
        youtubeList = newYoutubeList
        notifyDataSetChanged()
    }
}