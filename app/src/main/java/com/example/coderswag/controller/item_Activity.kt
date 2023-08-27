package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.R
import com.example.coderswag.Utilities.Extra_Prod
import com.example.coderswag.databinding.ActivityItemBinding
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.model.Product

class item_Activity : AppCompatActivity() {
    lateinit var  product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
         val binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
product= intent.getParcelableExtra(Extra_Prod)!!
        binding.ItemName.text= product.title
        binding.ItemPrice.text=product.price

        val resourcedId= this.resources.getIdentifier(product.image,"drawable",this.packageName)
        binding.imageView.setImageResource(resourcedId)
    }
}