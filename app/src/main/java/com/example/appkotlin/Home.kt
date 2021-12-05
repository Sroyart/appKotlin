package com.example.appkotlin

import android.content.Intent
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
        val buttonSearch = findViewById(R.id.buttonSearch) as Button
        buttonSearch.setOnClickListener{
            val intent = Intent(this, Search::class.java)
            startActivity(intent)

        }
    }
}