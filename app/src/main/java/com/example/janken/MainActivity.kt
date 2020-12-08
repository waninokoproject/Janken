package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var gu = findViewById<ImageButton>(R.id.Gu)
        var choki = findViewById<ImageButton>(R.id.Choki)
        var pa = findViewById<ImageButton>(R.id.Pa)

        gu.setOnClickListener{ onJankenButtonTapped(it) }
        choki.setOnClickListener{ onJankenButtonTapped(it) }
        pa.setOnClickListener{ onJankenButtonTapped(it) }
    }
    
    fun onJankenButtonTapped(view: View?){
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }
}