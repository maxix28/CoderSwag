package com.example.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.coderswag.R
import com.example.coderswag.model.Category
import com.example.coderswag.databinding.ListItemBinding


class CategoryApter( val context: Context, val categories:List<Category>) :BaseAdapter(){
   ///private lateinit var binding: ListItemBinding
//    binding = ListItemBinding.inflate(layoutInflater)
//    val view = binding.root
//    setContentView(view)
//    private val binding: ListItemBinding = ListItemBinding.inflate(
//        LayoutInflater.from(context),
//        this,
//        true
//    )
   init{
   // binding = ListItemBinding.inflate(LayoutInflater.from(context), this, true)
   }
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
        val categoryView:View
        val category=categories[position]
        categoryView = LayoutInflater.from(context).inflate(R.layout.list_item,null)
        if (convertView == null) {
            binding = ListItemBinding.inflate(inflater, parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ListItemBinding
        }
        binding.categoryText.text=category.title
        val resourcedId= context.resources.getIdentifier(category.image,"drawable",context.packageName)
        //categoryView.
        //binding = ListItemBinding.inflate(LayoutInflater.from(context), this, true)
println(resourcedId)
        binding.categoryImage.setImageResource(resourcedId)
        //val text= findViewById(R.id.categoryText)
       // return categoryView
        return binding.root
    }


}