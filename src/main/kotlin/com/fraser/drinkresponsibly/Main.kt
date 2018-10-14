package com.fraser.drinkresponsibly

fun main(args: Array<String>) {

    val establishment = listOf(
            AvailableDrinks.can330,
            AvailableDrinks.bottle275,
            AvailableDrinks.pint)

    val units = 1.5
    val maxDrinks = 3

    val recommendations: MutableMap<Drink, List<Recommendation>> = mutableMapOf()

    for (drink in establishment) {
        recommendations.put(drink, RecommendForMultipleDrinks.recommendMaxAbvAndNumberOfDrinks(drink, units, maxDrinks))
    }

    for (recommendation in recommendations) {
        println(recommendation)
    }
}

