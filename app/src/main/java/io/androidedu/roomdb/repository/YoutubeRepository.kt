package io.androidedu.roomdb.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import io.androidedu.roomdb.dao.YoutubeDAO
import io.androidedu.roomdb.db.YoutubeRoomDatabase
import io.androidedu.roomdb.entity.YoutubeDTO


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │
//│ ─────────────────────────── │
//│ 22.09.2018 - 09:25          │
//└─────────────────────────────┘

//TODO 10 Repository class'ını yaz.
class YoutubeRepository internal constructor(application: Application) {

    private val youtubeDAO: YoutubeDAO
    val allVideos: LiveData<List<YoutubeDTO>>

    init {

        val db = YoutubeRoomDatabase.getInstance(application)
        youtubeDAO = db!!.youtubeDAO()
        allVideos = youtubeDAO.getAllVideos()
    }


    fun insert(youtubeDTO: YoutubeDTO) {
        InsertAsyncTask(youtubeDAO).execute(youtubeDTO)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: YoutubeDAO) : AsyncTask<YoutubeDTO, Void, Void>() {

        override fun doInBackground(vararg params: YoutubeDTO): Void? {
            mAsyncTaskDao.insertVideo(params[0])
            return null
        }
    }
}