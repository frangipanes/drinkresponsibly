package com.fraser.drinkresponsibly

data class Recommendation(val numberOfDrinks: Double, val abv: Double) {
    override fun toString(): String {
        return String.format("%.1f @ %.1f%%", numberOfDrinks, abv)
    }
}

fun List<Recommendation>.getNth(n: Int): Recommendation {
    return this.getNth(n.toDouble())
}

fun List<Recommendation>.getNth(n: Double): Recommendation {
    for (recommendation in this) {
        if (recommendation.numberOfDrinks == n) {
            return recommendation
        }
    }

    throw IndexOutOfBoundsException()
}