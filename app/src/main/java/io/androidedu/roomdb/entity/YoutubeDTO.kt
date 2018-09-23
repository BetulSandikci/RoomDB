package io.androidedu.roomdb.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:10          │
//└─────────────────────────────┘

// TODO 3 entity class'ını oluştur.
// TODO 4 @PrimaryKey, NonNull, ColumnInfo dikkat !
@Entity(tableName = "youtube_videos")
data class YoutubeDTO(@PrimaryKey
                      @NonNull
                      @ColumnInfo(name = "video_id") val videoID: Int,
                      @ColumnInfo(name = "video_name") val videoName: String) {

    constructor() : this(0, "")
}