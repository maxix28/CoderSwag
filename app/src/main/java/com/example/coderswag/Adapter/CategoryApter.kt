package com.example.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.coderswag.R
import com.example.coderswag.model.Category
import com.example.coderswag.databinding.ListItemBinding


class CategoryApter( val context: Context, val categories:List<Category>) :BaseAdapter(){

  private lateinit var  holder:ViewHolder;



    override fun getCount(): Int {
       return categories.count()

    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListItemBinding
        val inflater = LayoutInflater.from(context)

        val category=categories[position]

        if (convertView == null) {
            binding = ListItemBinding.inflate(inflater, parent, false)// for binding
             holder= ViewHolder(binding)
            binding.root.tag = holder
            println("First time")
        } else {
            holder= convertView.tag as ViewHolder
            binding = holder.binding
            println("AGAINE")

        }

        val resourcedId= context.resources.getIdentifier(category.image,"drawable",context.packageName)//change image


        holder.bind(category,resourcedId)
        return binding.root
    }
private class ViewHolder(val binding: ListItemBinding){
    fun bind(item: Category, id : Int) {
        binding.categoryText.text = item.title
        binding.categoryImage.setImageResource(id)
       // binding.categoryImage.text = item.image
    }
}

}