package io.androidedu.roomdb

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnSave.setOnClickListener {

            val replyIntent = Intent()
            if (TextUtils.isEmpty(edtName.text)) {
                setResult(RESULT_CANCELED, replyIntent)
            } else {
                val name = edtName.text.toString()
                replyIntent.putExtra("name", name)
                setResult(RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}
