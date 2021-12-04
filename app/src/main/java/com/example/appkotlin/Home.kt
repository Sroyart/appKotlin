package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val buttonArticle = findViewById(R.id.buttonArticle) as Button
        buttonArticle.setOnClickListener {
            Toast.makeText(this@Home, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }
}