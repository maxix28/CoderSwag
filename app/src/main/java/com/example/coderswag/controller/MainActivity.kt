package com.example.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.coderswag.R
import com.example.coderswag.model.Category
import com.example.coderswag.serices.DataService
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.Adapter.CategoryApter
import com.example.coderswag.Adapter.CategoryRecycleAdapter
import com.example.coderswag.Utilities.Extra_Category
import com.example.coderswag.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
   // var fruits = arrayOf("Apple","Pindsf","sgvdfg","swertewrgfg")
    //private lateinit var adapter :ArrayAdapter<Category>
    private lateinit var adapter : CategoryRecycleAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     // adapter =  new ArrayAdapter<String>(this,  android.R.layout.activity_list_item, fruits)
        try {
            //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)
           adapter=CategoryRecycleAdapter(this,DataService.categories){
               category -> println(category.title)
               val productIntent = Intent(this,ProductsActivity::class.java)
              productIntent.putExtra(Extra_Category,category.title)
               startActivity(productIntent)
           }
            binding.categoryListView.adapter = adapter
            val layoutmanager= LinearLayoutManager(this)
            binding.categoryListView.layoutManager=layoutmanager
           binding.categoryListView.setHasFixedSize(true)
        }
        catch (e:Exception){

            binding.textView.text="WRONG"
        }
    }
}