package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.coderswag.R
import com.example.coderswag.model.Category
import com.example.coderswag.serices.DataService
import android.widget.ListView
import com.example.coderswag.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var fruits = arrayOf("Apple","Pindsf","sgvdfg","swertewrgfg")
    private lateinit var adapter :ArrayAdapter<Category>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     // adapter =  new ArrayAdapter<String>(this,  android.R.layout.activity_list_item, fruits)
        try {
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)
            binding.categoryListView.adapter = adapter
        }
        catch (e:Exception){

            binding.textView.text="WRONG"
        }
    }
}