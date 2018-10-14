package com.fraser.drinkresponsibly

import kotlin.math.abs

interface Recommender {
    fun getRecommendations(
        drink: Drink,
        units: Double
    ): List<Recommendation>

    fun getMaxAbv(drink: Drink, units: Double, numberOfDrinks: Double): Double
}

class RecommenderImpl(
    private val minAbv: Double = 0.5,
    private val maxAbv: Double = 40.0,
    private val maxDrinks: Double = 20.0
) : Recommender {

    override fun getRecommendations(
        drink: Drink,
        units: Double
    ): List<Recommendation> {
        val list: MutableList<Recommendation> = mutableListOf()

        var numberOfDrinks = 0.0 + drink.stepSize

        while (numberOfDrinks <= maxDrinks) {
            val recommendation =
                Recommendation(numberOfDrinks, getMaxAbv(drink, units, numberOfDrinks))

            if (recommendation.abv in minAbv..maxAbv) {
                list += recommendation
            }

            numberOfDrinks += drink.stepSize
        }

        return list.sortedWith(compareBy(Recommendation::numberOfDrinks))
    }

    override fun getMaxAbv(drink: Drink, units: Double, numberOfDrinks: Double): Double {
        return 1000.0 * abs(units) / abs(drink.size) / numberOfDrinks
    }

}