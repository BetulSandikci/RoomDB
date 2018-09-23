package io.androidedu.roomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.androidedu.roomdb.entity.YoutubeDTO


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:15          │
//└─────────────────────────────┘

// TODO 5 DAO class'ını yaz.
// TODO 6 Dao, Insert, Query, Delete, Update Dikkat !
@Dao
interface YoutubeDAO {

    @Insert(onConflict = REPLACE)
    fun insertVideo(youtubeDTO: YoutubeDTO)

    @Query("DELETE FROM youtube_videos")
    fun deleteAll()

    // TODO 7 LiveData dikkat !
    @Query("SELECT * from youtube_videos ORDER BY video_name ASC")
    fun getAllVideos(): LiveData<List<YoutubeDTO>>
}