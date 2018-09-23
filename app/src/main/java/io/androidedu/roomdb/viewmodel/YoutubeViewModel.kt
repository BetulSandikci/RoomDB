package io.androidedu.roomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.androidedu.roomdb.entity.YoutubeDTO
import io.androidedu.roomdb.repository.YoutubeRepository


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:31          │
//└─────────────────────────────┘

// TODO 12 viewmodel class'ını olustur.
class YoutubeViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: YoutubeRepository

    internal val allVideos: LiveData<List<YoutubeDTO>>

    init {
        mRepository = YoutubeRepository(application)
        allVideos = mRepository.allVideos
    }

    fun insert(youtubeDTO: YoutubeDTO) {
        mRepository.insert(youtubeDTO)
    }
}