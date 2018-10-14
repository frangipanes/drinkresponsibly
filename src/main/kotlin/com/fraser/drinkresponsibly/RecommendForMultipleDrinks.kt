package com.fraser.drinkresponsibly

class RecommendForMultipleDrinks(private val minAbv: Double = 0.5, private val maxAbv: Double = 40.0, private val maxDrinks: Double = 20.0) {

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double):List<Recommendation> {
        return recommendMaxAbvAndNumberOfDrinks(drink, units, maxDrinks)
    }

    fun recommendMaxAbvAndNumberOfDrinks(drink: Drink, units: Double, maxDrinks: Double): List<Recommendation> {
        val list: MutableList<Recommendation> = mutableListOf()

        var numberOfDrinks = 0.0 + drink.stepSize

        while (numberOfDrinks <= maxDrinks) {
            val recommendation = getRecommendationForNDrinks(drink, units, numberOfDrinks)

            if (isAbvHigherThanMinimum(recommendation) && isAbvLowerThanMaximum(recommendation)) {
                list += recommendation
            }

            numberOfDrinks += drink.stepSize
        }

        return list.sortedWith(compareBy(Recommendation::numberOfDrinks))
    }

    private fun isAbvHigherThanMinimum(recommendation: Recommendation) =
            recommendation.abv >= minAbv

    private fun isAbvLowerThanMaximum(recommendation: Recommendation) =
            recommendation.abv <= maxAbv

    private fun getRecommendationForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Recommendation {
        val abv = getMaxAbvForNDrinks(drink, units, numberOfDrinks)
        return Recommendation(numberOfDrinks, abv)
    }

    private fun getMaxAbvForNDrinks(drink: Drink, units: Double, numberOfDrinks: Double): Double {
        return RecommendForOneDrink.recommendMaxAbvForOneDrink(drink, units) / numberOfDrinks
    }
}