package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Search : AppCompatActivity() {

    private lateinit var newRecyclerview : RecyclerView
    private lateinit var newArrayList : ArrayList<Data>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c
        )

        heading = arrayOf(
            "exemple a",
            "exemple b",
            "exemple c"
        )

        newRecyclerview = findViewById(R.id.recyclerview)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<Data>()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val data = Data(imageId[i],heading[i])
            newArrayList.add(data)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@Search, "Cliked on item $position",Toast.LENGTH_SHORT).show()
            }
        })
    }
}