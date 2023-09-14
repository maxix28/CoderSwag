package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coderswag.R
import com.example.coderswag.databinding.ActivityUserBuyBinding
import com.example.coderswag.model.Client
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class User_Buy : AppCompatActivity() {
    lateinit var firebaceRef: DatabaseReference
    lateinit var binding: ActivityUserBuyBinding
    lateinit var client: Client
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buyNowBTN.setOnClickListener {
            firebaceRef = FirebaseDatabase.getInstance().getReference("clients")

            binding.apply{
               // if(clientName.isEm)
                val name =clientName.text.toString()
                if(name.isEmpty()){clientName.error="Input your name"}
                val secondName=clientSecondName.text.toString()
                if(secondName.isEmpty()) clientSecondName.error="Input your second name "
                val phone =phoneNumber.text.toString()
                if(phone.isEmpty())phoneNumber.error="Input your phone number"

                client= Client(name,secondName, phone,"")
            println(client)
                Toast.makeText(this@User_Buy,client.toString(),Toast.LENGTH_SHORT).show()

            }
        }

    }
}