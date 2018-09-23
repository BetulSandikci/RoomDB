package io.androidedu.roomdb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.roomdb.adapter.YoutubeListAdapter
import io.androidedu.roomdb.entity.YoutubeDTO
import io.androidedu.roomdb.viewmodel.YoutubeViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val NEW_NAME_ACTIVITY_REQUEST_CODE = 1

    lateinit var youtubeViewModel: YoutubeViewModel

    var count = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewYoutubeList.apply {

            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.itemAnimator = DefaultItemAnimator()
            this.adapter = YoutubeListAdapter { Toast.makeText(this@MainActivity, "naber", Toast.LENGTH_SHORT).show() }
        }

        youtubeViewModel = ViewModelProviders.of(this).get(YoutubeViewModel::class.java)

        youtubeViewModel.allVideos.observe(this, Observer<List<YoutubeDTO>> {

            (recyclerViewYoutubeList.adapter as YoutubeListAdapter).setNewYoutubeList(it)
        })

        btnAddName.setOnClickListener {

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(intent, NEW_NAME_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_NAME_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val youtubeDTO = YoutubeDTO(count++, data!!.getStringExtra("name"))
            youtubeViewModel.insert(youtubeDTO)
        } else {
            Toast.makeText(this, "Olmadı", Toast.LENGTH_LONG).show()
        }
    }
}
