package com.fraser.drinkresponsibly

object AvailableDrinks {
    val stubbie = Drink("Stubbie", 150.0)
    val can330 = Drink("Can (330)", 330.0)
    val can440 = Drink("Can (440)", 440.0)
    val bottle275 = Drink("Bottle (275)", 275.0)
    val bottle330 = Drink("Bottle (330)", 330.0)
    val bottle500 = Drink("Bottle (500)", 500.0)
    val bottle660 = Drink("Bottle (660)", 660.0)
    val pint = Drink("Pint", 568.26)
    val metricPint = Drink("Metric pint", 500.0)
    val thirdPint = Drink("Third pint", 568.26 / 3)
    val wine125 = Drink("Wine (125)", 125.0)
    val wine175 = Drink("Wine (175)", 175.0)
    val wine250 = Drink("Wine (250)", 250.0)

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
            wine250)
}