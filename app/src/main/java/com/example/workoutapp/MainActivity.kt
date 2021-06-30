package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnstart.setOnClickListener {
            var intent=Intent(this, exceriseactivity::class.java)
            startActivity(intent)

        }
        btnhistory.setOnClickListener {
            Toast.makeText(this, "works", Toast.LENGTH_SHORT).show()
        }
        
        btnbmi.setOnClickListener {
            var intent=Intent(this,bmi::class.java)
            startActivity(intent)
        }
    }
}