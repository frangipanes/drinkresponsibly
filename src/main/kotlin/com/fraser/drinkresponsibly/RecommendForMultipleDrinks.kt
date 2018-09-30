package com.fraser.drinkresponsibly

object RecommendForMultipleDrinks {

    private const val MIN_ABV = 0.5
    private const val MAX_ABV = 40.0

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double): List<Recommendation> {
        val maxDrinks = 20

        val list: MutableList<Recommendation> = mutableListOf()

        for (numberOfDrinks in 1..maxDrinks) {
            val recommendation = getRecommendationForNDrinks(drink, units, numberOfDrinks.toDouble())

            if (isAbvHigherThanMinimum(recommendation) && isAbvLowerThanMaximum(recommendation)) {
                list += recommendation
            }
        }

        return list.sortedWith(compareBy(Recommendation::numberOfDrinks))
    }

    private fun isAbvHigherThanMinimum(recommendation: Recommendation) =
            recommendation.abv >= MIN_ABV

    private fun isAbvLowerThanMaximum(recommendation: Recommendation) =
            recommendation.abv <= MAX_ABV

    private fun getRecommendationForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Recommendation {
        val abv = getMaxAbvForNDrinks(drink, units, numberOfDrinks)
        return Recommendation(numberOfDrinks, abv)
    }

    private fun getMaxAbvForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Double {
        return RecommendForOneDrink.recommendMaxAbvForOneDrink(drink, units) / numberOfDrinks
    }
}