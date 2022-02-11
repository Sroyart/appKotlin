package com.example.appkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class Search : AppCompatActivity() {

    private lateinit var newRecyclerview : RecyclerView
    private lateinit var newArrayList : ArrayList<Data>
    private lateinit var tempArrayList: ArrayList<Data>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var products : Array<String>


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

        products = arrayOf(
            getString(R.string.product_a),
            getString(R.string.product_b),
            getString(R.string.product_c)

        )

        newRecyclerview = findViewById(R.id.recyclerview)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<Data>()
        tempArrayList = arrayListOf<Data>()
        getUserData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item,menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    newArrayList.forEach{
                        if (it.heading.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.add(it)
                        }
                    }

                    newRecyclerview.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    newRecyclerview.adapter!!.notifyDataSetChanged()
                }

                return false

            }
        })

        return super.onCreateOptionsMenu(menu)
    }
    private fun getUserData() {
        for (i in imageId.indices) {
            val data = Data(imageId[i],heading[i])
            newArrayList.add(data)
        }
        tempArrayList.addAll(newArrayList)

        var adapter = MyAdapter(tempArrayList)
        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@Search,ProductDetail::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageId", newArrayList[position].titleImage)
                intent.putExtra("products",products[position])
                startActivity(intent)
            }
        })
    }
}