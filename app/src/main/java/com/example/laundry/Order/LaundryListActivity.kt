package com.example.laundry.Order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laundry.Adapter.Laundry
import com.example.laundry.Adapter.LaundryAdapter
import com.example.laundry.Pesan.FormActivity
import com.example.laundry.R

class LaundryListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var laundryAdapter: LaundryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laundry_list)
        recyclerView = findViewById(R.id.recyclerViewLaundry)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Contoh data laundry
        val laundryList = createDummyLaundryList()

        laundryAdapter = LaundryAdapter(laundryList)
        recyclerView.adapter = laundryAdapter


    }

    private fun createDummyLaundryList(): List<Laundry> {
        val laundryList = mutableListOf<Laundry>()
        laundryList.add(Laundry("laundry sempaja", R.drawable.laundry2))
        laundryList.add(Laundry("laundry pramuka", R.drawable.laundry3))
        laundryList.add(Laundry("laundry pramuka", R.drawable.laundry1))
        laundryList.add(Laundry("laundry pramuka", R.drawable.laundry4))
        laundryList.add(Laundry("laundry pramuka", R.drawable.laundry2))
        // Tambahkan data laundry lainnya sesuai kebutuhan
        return laundryList




    }


    }
