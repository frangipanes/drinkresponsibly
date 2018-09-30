package com.fraser.drinkresponsibly

object RecommendForMultipleDrinks {

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double): List<Pair<Double, Double>> {
        val maxDrinks = 20

        val list: MutableList<Pair<Double, Double>> = mutableListOf()

        for (numberOfDrinks in 1..maxDrinks) {
            list += getRecommendationForNDrinks(drink, units, numberOfDrinks.toDouble())
        }

        return list.sortedWith(compareBy { it.first })
    }

    private fun getRecommendationForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Pair<Double, Double> {
        val abv = getMaxAbvForNDrinks(drink, units, numberOfDrinks)
        return Pair(numberOfDrinks, abv)
    }

    private fun getMaxAbvForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Double {
        return RecommendForOneDrink.recommendMaxAbvForOneDrink(drink, units) / numberOfDrinks
    }
}