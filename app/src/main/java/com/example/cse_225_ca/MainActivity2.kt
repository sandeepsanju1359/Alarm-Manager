package com.example.cse_225_ca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val i =Intent(this,MainActivity::class.java)
                startActivity(i)
                finish()
            },5000
        )


    }
}