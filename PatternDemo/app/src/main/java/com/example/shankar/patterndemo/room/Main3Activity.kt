package com.example.shankar.patterndemo.room

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.example.shankar.patterndemo.compose.ComposeActivity
import com.example.shankar.patterndemo.room.adapter.UsersAdapter
import com.example.shankar.patterndemo.room.model.User
import com.example.shankar.patterndemo.room.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main3.*



class Main3Activity : AppCompatActivity() {

    lateinit var adapter: UsersAdapter
    lateinit var viewModel: UserViewModel
    val NEW_WORD_ACTIVITY_REQUEST_CODE:Int = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.shankar.patterndemo.R.layout.activity_main3)

        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UsersAdapter()
        recyclerView.adapter = adapter

        viewModel.allUsers.observe(this, object:Observer<List<User>>{
            override fun onChanged(t: List<User>?) {
                if(t != null) {
                    adapter.setList(t)
                }
            }

        })

        val fab: FloatingActionButton = findViewById(com.example.shankar.patterndemo.R.id.fab)
        fab.setOnClickListener {
//            val intent = Intent(this@Main3Activity, NewUserActivity::class.java)
//            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)

            startActivity(Intent(this@Main3Activity, ComposeActivity::class.java))
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val user = User(data!!.getStringExtra("name"))
            viewModel.insert(user)
        } else {
            Toast.makeText(this, com.example.shankar.patterndemo.R.string.empty_not_saved, Toast.LENGTH_LONG).show();
        }
    }

}
