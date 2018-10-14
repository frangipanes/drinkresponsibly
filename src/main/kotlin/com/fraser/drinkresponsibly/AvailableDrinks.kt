package com.fraser.drinkresponsibly

object AvailableDrinks {
    val stubbie = Bottle("Stubbie", 150.0)
    val can330 = Can("Can (330)", 330.0)
    val can440 = Can("Can (440)", 440.0)
    val bottle275 = Bottle("Bottle (275)", 275.0)
    val bottle330 = Bottle("Bottle (330)", 330.0)
    val bottle500 = Bottle("Bottle (500)", 500.0)
    val bottle660 = Bottle("Bottle (660)", 660.0)
    val pint = Pint("Pint", 568.26)
    val metricPint = Pint("Metric pint", 500.0)
    val thirdPint = Pint("Third pint", 568.26 / 3)
    val wine125 = Wine("Wine (125)", 125.0)
    val wine175 = Wine("Wine (175)", 175.0)
    val wine250 = Wine("Wine (250)", 250.0)

    val availableDrinks = listOf(
        stubbie,
        can330,
        can440,
        bottle275,
        bottle330,
        bottle500,
        bottle660,
        pint,
        metricPint,
        thirdPint,
        wine125,
        wine175,
        wine250
    )
}