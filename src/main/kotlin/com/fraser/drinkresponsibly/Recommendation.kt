package com.fraser.drinkresponsibly

data class Recommendation(val numberOfDrinks: Double, val abv: Double) {
    override fun toString(): String {
        return String.format("%.1f @ %.1f%%", numberOfDrinks, abv)
    }
}

fun <T> List<T>.getNth(n: Int): T {
    return this[n - 1]
}