package com.example.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.Adapter.ProductAdapter
import com.example.coderswag.R
import com.example.coderswag.Utilities.Extra_Category
import com.example.coderswag.Utilities.Extra_Prod
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.databinding.ActivityProductsBinding
import com.example.coderswag.model.Category
import com.example.coderswag.model.Product
import com.example.coderswag.serices.DataService

class ProductsActivity : AppCompatActivity() {
    lateinit var  adapter :ProductAdapter
    var product=Product("f","f","g")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val  binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val CategorY_Type =intent.getStringExtra(Extra_Category)
        println(CategorY_Type)
adapter= CategorY_Type?.let { DataService.getProducts(it) }?.let { ProductAdapter(this, it){
val productIntent= Intent(this,item_Activity::class.java)
 //productIntent.putExtra(Extra_Prod,it)
    productIntent.putExtra(Extra_Prod,it)
    startActivity(productIntent)
} }!!
        val layoutmanager= GridLayoutManager(this,2)
        binding.productListView.layoutManager=layoutmanager
        binding.productListView.adapter=adapter
    }
}


