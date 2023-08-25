package com.example.coderswag.serices

import com.example.coderswag.model.Category
import com.example.coderswag.model.Product

object DataService  {
    val categories = listOf(
        Category("SHIRT","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage"), Category("SHIRT","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage"), Category("SHIRT","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage")
    )
val hats = listOf(
    Product("Devslopes Graphic Beanie", "$18","hat01"),
    Product("Devslopes Hat Black", "$20","hat02"),
    Product("Devslopes Hat White", "$18","hat03"),
    Product("Devslopes Hat Snapback", "$22","hat04")
)
val hoodies= listOf(
    Product("Devslopes Hoodie Gray", "$28","hoodie01"),
    Product("Devslopes Hoodie Red", "$32","hoodie02"),
    Product("Devslopes Gray Hoodie", "$28","hoodie03"),
    Product("Devslopes Black Hoodie", "$32","hoodie04"),
    )

    val shirt= listOf(
        Product("Devslopes Shirt Black ", "$28","shirt01"),
        Product("Devslopes Badge Light Gray ", "$20","shirt02"),
        Product("Devslopes Logo Shirt Red ", "$20","shirt03"),
        Product("Devslopes Hustle ", "$22","shirt04"),
        Product("Kickflip Studio", "$18","shirt05"),


        )
}