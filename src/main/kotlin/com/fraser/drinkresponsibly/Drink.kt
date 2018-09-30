package com.fraser.drinkresponsibly

interface Drink {
    val name: String
    val size: Double
}

data class Bottle(override val name: String, override val size: Double) : Drink
data class Can(override val name: String, override val size: Double) : Drink
data class Pint(override val name: String, override val size: Double) : Drink
data class Wine(override val name: String, override val size: Double) : Drink