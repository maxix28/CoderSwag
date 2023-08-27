package com.example.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.databinding.ListItemBinding
import com.example.coderswag.databinding.ProductListItemBinding
import com.example.coderswag.model.Category
import com.example.coderswag.model.Product


class ProductAdapter( val context: Context, val products:List<Product>, val itemClick:(Product)->Unit) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {



    inner class ProductHolder(private val binding: ProductListItemBinding, val itemClick:(Product)->Unit):RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product,context: Context) {

        }

        fun bind(product: Product) {
            binding.ProductName.text = product.title
            val resourcedId= context.resources.getIdentifier(product.image,"drawable",context.packageName)//change image
            binding.ProductImage.setImageResource(resourcedId)
            binding.ProductPrice.text=product.price
            binding.root.setOnClickListener{itemClick(product)}
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductListItemBinding.inflate(inflater, parent, false)
        return ProductHolder(binding,itemClick)
    }

    override fun getItemCount(): Int {
     return  products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
holder.bind(product)
    }
}