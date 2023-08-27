package com.example.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
//import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.databinding.ListItemBinding
import com.example.coderswag.model.Category


class CategoryRecycleAdapter(val context: Context, val categories : List<Category> , val itemClick:(Category)->Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    inner class Holder(private val binding: ListItemBinding, val itemClick:(Category)->Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.categoryText.text = category.title
            val resourcedId= context.resources.getIdentifier(category.image,"drawable",context.packageName)//change image

            binding.categoryImage.setImageResource(resourcedId)
binding.root.setOnClickListener { itemClick(category) }

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return Holder(binding,itemClick)

    }

    override fun getItemCount(): Int {
      return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }
}