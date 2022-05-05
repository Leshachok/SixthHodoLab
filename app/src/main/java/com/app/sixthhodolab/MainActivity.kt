package com.app.sixthhodolab

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nums = List(100) { Random.nextInt(0, 99) }
        val data = nums.map { item ->
            val color = Random.nextInt(Int.MIN_VALUE, Int.MAX_VALUE)
            GridItem(item, color)
        }

        val adapter = GridAdapter(layoutInflater, this)
        adapter.submitList(data)

        val gridView = findViewById<RecyclerView>(R.id.gridView)
        gridView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            setAdapter(adapter)
        }

    }
}