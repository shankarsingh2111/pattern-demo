package com.example.shankar.patterndemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.shankar.patterndemo.R

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        val asc = Array(5) { i->
            i*i*i
        }
        Toast.makeText(this, asc.toString(), Toast.LENGTH_LONG).show()

    }
}
