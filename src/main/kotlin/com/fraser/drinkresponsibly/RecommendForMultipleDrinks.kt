package com.fraser.drinkresponsibly

object RecommendForMultipleDrinks {

    private const val MIN_ABV = 0.5
    private const val MAX_ABV = 40.0

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double): List<Pair<Double, Double>> {
        val maxDrinks = 20

        val list: MutableList<Pair<Double, Double>> = mutableListOf()

        for (numberOfDrinks in 1..maxDrinks) {
            val recommendation = getRecommendationForNDrinks(drink, units, numberOfDrinks.toDouble())

            if (isAbvHigherThanMinimum(recommendation) && isAbvLowerThanMaximum(recommendation)) {
                list += recommendation
            }
        }

        return list.sortedWith(compareBy { it.first })
    }

    private fun isAbvHigherThanMinimum(recommendation: Pair<Double, Double>) =
            recommendation.second >= MIN_ABV

    private fun isAbvLowerThanMaximum(recommendation: Pair<Double, Double>) =
            recommendation.second <= MAX_ABV

    private fun getRecommendationForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Pair<Double, Double> {
        val abv = getMaxAbvForNDrinks(drink, units, numberOfDrinks)
        return Pair(numberOfDrinks, abv)
    }

    private fun getMaxAbvForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Double {
        return RecommendForOneDrink.recommendMaxAbvForOneDrink(drink, units) / numberOfDrinks
    }
}