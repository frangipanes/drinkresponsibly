package com.fraser.drinkresponsibly

data class Recommendation(val numberOfDrinks: Double, val maximumAbv: Double) {
    override fun toString(): String {
        return String.format("%.1f, %.1f%)", numberOfDrinks, maximumAbv)
    }
}