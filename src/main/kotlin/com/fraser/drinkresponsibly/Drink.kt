package com.fraser.drinkresponsibly

interface Drink {
    val name: String
    val size: Double
    val stepSize: Double
}

data class Bottle(override val name: String, override val size: Double) : Drink {
    override val stepSize: Double
        get() = 1.0
}

data class Can(override val name: String, override val size: Double) : Drink {
    override val stepSize: Double
        get() = 1.0
}

data class Pint(override val name: String, override val size: Double) : Drink {
    override val stepSize: Double
        get() = 0.5
}

data class Wine(override val name: String, override val size: Double) : Drink {
    override val stepSize: Double
        get() = 1.0
}