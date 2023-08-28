package com.example.coderswag.controller

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coderswag.R
import com.example.coderswag.Utilities.Extra_Prod
import com.example.coderswag.databinding.ActivityItemBinding
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
        binding.ToBusketBTN.setBackgroundColor(3328)
        binding.button.setOnClickListener {
            println("BUY")
            Toast.makeText(this, "Bought ${product.title}", Toast.LENGTH_SHORT).show()

        }
        binding.ToBusketBTN.setOnClickListener {
            if (binding.ToBusketBTN.isChecked==true) {
                println("Add")
                Toast.makeText(this, "Added ${product.title}", Toast.LENGTH_SHORT).show()
            }
            else{
                println("Delete")
                Toast.makeText(this, "Deleted ${product.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
fun showToast(context: Context) {
    Toast.makeText(context, "Choose your skill", Toast.LENGTH_SHORT).show()
}
fun OnBuy(view: View){
println("BUY")
}