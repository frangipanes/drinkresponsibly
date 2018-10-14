package com.fraser.drinkresponsibly

fun main(args: Array<String>) {

    val establishment = listOf(AvailableDrinks.stubbie,
            AvailableDrinks.can330,
            AvailableDrinks.can440,
            AvailableDrinks.bottle275,
            AvailableDrinks.bottle330,
            AvailableDrinks.bottle500,
            AvailableDrinks.bottle660)

    val units = 1.5
    val maxDrinks = 3

    val recommendations: MutableMap<Drink, List<Recommendation>> = mutableMapOf()

    for (drink in establishment) {
        recommendations.put(drink, RecommendForMultipleDrinks.recommendMaxAbvAndNumberOfDrinks(drink, units, maxDrinks))
    }

    println(recommendations)
}

