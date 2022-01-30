package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val headingProduct : TextView = findViewById(R.id.heading)
        val mainProduct : TextView = findViewById(R.id.product)
        val imageProduct : ImageView = findViewById(R.id.image_heading)

        val bundle : Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val product = bundle.getString("products")

        headingProduct.text = heading
        mainProduct.text = product
        imageProduct.setImageResource(imageId)
    }
}