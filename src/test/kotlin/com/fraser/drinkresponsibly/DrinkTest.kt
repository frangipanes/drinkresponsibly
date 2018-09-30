package com.fraser.drinkresponsibly

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DrinkTest {

    @Test
    internal fun `drink has same name and size as set by constructor`() {
        val bottle = Bottle("Bottle", 275.0)
        assertThat(bottle.name).isEqualTo("Bottle")
        assertThat(bottle.size).isEqualTo(275.0)
    }

    @Test
    internal fun availableDrinksIncludesAllDrinks() {
        assertThat(AvailableDrinks.availableDrinks).containsExactlyInAnyOrder(
                AvailableDrinks.bottle275,
                AvailableDrinks.bottle330,
                AvailableDrinks.bottle500,
                AvailableDrinks.bottle660,
                AvailableDrinks.can330,
                AvailableDrinks.can440,
                AvailableDrinks.metricPint,
                AvailableDrinks.pint,
                AvailableDrinks.stubbie,
                AvailableDrinks.thirdPint,
                AvailableDrinks.wine125,
                AvailableDrinks.wine175,
                AvailableDrinks.wine250
        )
    }
}