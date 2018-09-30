package com.fraser.drinkresponsibly

import kotlin.math.abs

object Recommend {

    fun recommendMaxAbvForOneDrink(drink: Drink, units: Double): Double {
        return 1000.0 * abs(units) / abs(drink.size)
    }
}