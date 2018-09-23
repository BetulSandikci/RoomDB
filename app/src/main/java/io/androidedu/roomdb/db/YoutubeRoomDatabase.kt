package io.androidedu.roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.roomdb.dao.YoutubeDAO
import io.androidedu.roomdb.entity.YoutubeDTO


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:21          │
//└─────────────────────────────┘

// TODO 8 db class'ını yaz.
// TODO 9 entities, version, instance olusturma Dikkat !
@Database(entities = arrayOf(YoutubeDTO::class), version = 1)
abstract class YoutubeRoomDatabase : RoomDatabase() {

    abstract fun youtubeDAO(): YoutubeDAO

    companion object {
        private var INSTANCE: YoutubeRoomDatabase? = null

        fun getInstance(context: Context): YoutubeRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(YoutubeRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            YoutubeRoomDatabase::class.java, "youtube_video_database")
                            .fallbackToDestructiveMigration()
//                            .addCallback(object : RoomDatabase.Callback() {
//
//                                override fun onOpen(db: SupportSQLiteDatabase) {
//                                    super.onOpen(db)
//                                    PopulateDbAsync(INSTANCE!!).execute()
//                                }
//                            })
                            .build()
                }
            }
            return INSTANCE
        }
    }
}

//private class PopulateDbAsync internal constructor(db: YoutubeRoomDatabase) : AsyncTask<Void, Void, Void>() {
//
//    private val mDao: YoutubeDAO = db.youtubeDAO()
//
//    override fun doInBackground(vararg params: Void): Void? {
//
//        mDao.deleteAll()
//        val youtubeDTO = YoutubeDTO(1, "naber")
//        mDao.insertVideo(youtubeDTO)
//
//        val youtubeDTO2 = YoutubeDTO(2, "iyidir senden?")
//        mDao.insertVideo(youtubeDTO2)
//
//        return null
//    }
//}