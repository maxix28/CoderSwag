package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coderswag.R
import com.example.coderswag.Utilities.Extra_Prod
import com.example.coderswag.databinding.ActivityUserBuyBinding
import com.example.coderswag.model.Client
import com.example.coderswag.model.Product
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class User_Buy : AppCompatActivity() {
    lateinit var firebaceRef: DatabaseReference
    lateinit var binding: ActivityUserBuyBinding
    lateinit var client: Client
    lateinit var product:Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        product= intent.getParcelableExtra(Extra_Prod)!!
        val resourcedId= this.resources.getIdentifier(product.image,"drawable",this.packageName)
        binding.productIMG.setImageResource(resourcedId)
        binding.productName.text= product.title

        binding.buyNowBTN.setOnClickListener {

            firebaceRef = FirebaseDatabase.getInstance().getReference("clients")


            binding.apply{
                GlobalScope.launch(Dispatchers.IO) {
                    // if(clientName.isEm)
                    val name = clientName.text.toString()
                    if (name.isEmpty()) {
                        clientName.error = "Input your name"
                    }
                    val secondName = clientSecondName.text.toString()
                    if (secondName.isEmpty()) clientSecondName.error = "Input your second name "
                    val phone = phoneNumber.text.toString()
                    if (phone.isEmpty()) phoneNumber.error = "Input your phone number"
                    val contactID = firebaceRef.push().key!!
                    client = Client(name, secondName, phone, product.title.toString())
                    println(client)
                    firebaceRef.child(contactID).setValue(client)
                        .addOnCompleteListener {
                            Toast.makeText(
                                this@User_Buy,
                                "we will call you later",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this@User_Buy, "error ${it.message}", Toast.LENGTH_SHORT)
                                .show()

                        }
                }
               // Toast.makeText(this@User_Buy,client.toString(),Toast.LENGTH_SHORT).show()
5

            }
        }

    }
}