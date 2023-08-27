package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.R
import com.example.coderswag.Utilities.Extra_Category

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val CategorY_Type =intent.getStringExtra(Extra_Category)
        println(CategorY_Type)
    }
}