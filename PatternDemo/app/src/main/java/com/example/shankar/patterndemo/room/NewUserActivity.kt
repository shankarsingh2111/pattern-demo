package com.example.shankar.patterndemo.room

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText


class NewUserActivity : AppCompatActivity() {
    lateinit var etUserName: EditText
    lateinit var bAddUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.shankar.patterndemo.R.layout.activity_new_user)

        etUserName = findViewById(com.example.shankar.patterndemo.R.id.etUserName)
        bAddUser = findViewById(com.example.shankar.patterndemo.R.id.bAddUser)

        bAddUser.setOnClickListener {
            v->
            val intent = Intent()
            if(TextUtils.isEmpty(etUserName.text.toString().trim())){
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val word = etUserName.getText().toString()
                intent.putExtra("name", word)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }

        etUserName.setOnEditorActionListener { _, _, _ ->
            bAddUser.performClick()
        }

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        etUserName.post { Utils.showSoftKeyboard(etUserName) }

    }
}
