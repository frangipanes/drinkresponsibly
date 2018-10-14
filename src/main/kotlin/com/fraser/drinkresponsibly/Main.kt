package com.fraser.drinkresponsibly

fun main(args: Array<String>) {

    val establishment = listOf(
        AvailableDrinks.can330,
        AvailableDrinks.bottle275,
        AvailableDrinks.pint
    )

    val units = 1.5

    val recommendations: MutableMap<Drink, List<Recommendation>> = mutableMapOf()

    for (drink in establishment) {
        recommendations[drink] = RecommenderImpl(3.0, 6.0, 3.0).getRecommendations(drink, units)
    }

    for (recommendation in recommendations) {
        println(recommendation)
    }
}

