package io.androidedu.roomdb

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import io.androidedu.roomdb.enums.SharedPrefKey
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPrefActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private val sharedPref by lazy { getSharedPreferences(SharedPrefKey.PrivateSharedPref.toString(), Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        chkRememberUserName.setOnCheckedChangeListener(this)

        if (!getUserName().isEmpty()) {

            edtUserName.setText(getUserName())
            chkRememberUserName.isChecked = true
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if (isChecked && !edtUserName.text.toString().trim().isEmpty()) {

            sharedPref.edit().setUserName(edtUserName.text.toString())
        } else {

            sharedPref.edit().setUserName("")
        }
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun getUserName(): String {
        return sharedPref.getString(SharedPrefKey.UserName.toString(), "")
    }
}

fun SharedPreferences.Editor.setUserName(userName: String) {

    with(this) {

        putString(io.androidedu.roomdb.enums.SharedPrefKey.UserName.toString(), userName)
        apply()
    }
}
