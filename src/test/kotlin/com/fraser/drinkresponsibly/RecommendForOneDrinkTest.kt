package com.fraser.drinkresponsibly

import com.fraser.drinkresponsibly.RecommendForOneDrink.recommendMaxAbvForOneDrink
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecommendForOneDrinkTest {

    @Test
    internal fun `recommend 3% abv for 1 unit in a 330ml can`() {
        assertThat(recommendMaxAbvForOneDrink(AvailableDrinks.can330, 1.0)).isCloseTo(
            3.0,
            within(0.1)
        )
    }

    @Test
    internal fun `recommend 3% abv for -1 unit in a 330ml can`() {
        assertThat(recommendMaxAbvForOneDrink(AvailableDrinks.can330, -1.0)).isCloseTo(
            3.0,
            within(0.1)
        )
    }

    @Test
    internal fun `recommend 4% abv for 2 units in a metric pint`() {
        assertThat(recommendMaxAbvForOneDrink(AvailableDrinks.metricPint, 2.0)).isCloseTo(
            4.0,
            within(0.1)
        )
    }

    @Test
    internal fun `recommend infinite abv for max double units in a metric pint`() {
        assertThat(
            recommendMaxAbvForOneDrink(
                AvailableDrinks.metricPint,
                Double.MAX_VALUE
            )
        ).isCloseTo(Double.POSITIVE_INFINITY, within(0.1))
    }

    @Test
    internal fun `recommend min double abv for min double units in a metric pint`() {
        assertThat(
            recommendMaxAbvForOneDrink(
                AvailableDrinks.metricPint,
                Double.MIN_VALUE
            )
        ).isCloseTo(Double.MIN_VALUE, within(0.1))
    }
}