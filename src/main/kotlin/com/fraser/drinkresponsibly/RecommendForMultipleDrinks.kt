package com.fraser.drinkresponsibly

object RecommendForMultipleDrinks {

    private const val MIN_ABV = 0.5
    private const val MAX_ABV = 40.0
    private const val DEFAULT_MAX_DRINKS = 20

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double):List<Recommendation> {
        return recommendMaxAbvAndNumberOfDrinks(drink, units, DEFAULT_MAX_DRINKS)
    }

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double, maxDrinks: Int): List<Recommendation> {
        val list: MutableList<Recommendation> = mutableListOf()

        var numberOfDrinks = 1.0

        while (numberOfDrinks <= maxDrinks.toDouble()) {
            val recommendation = getRecommendationForNDrinks(drink, units, numberOfDrinks)

            if (isAbvHigherThanMinimum(recommendation) && isAbvLowerThanMaximum(recommendation)) {
                list += recommendation
            }

            numberOfDrinks += drink.stepSize
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