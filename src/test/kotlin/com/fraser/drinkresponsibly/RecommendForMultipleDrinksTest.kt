package com.fraser.drinkresponsibly

import com.fraser.drinkresponsibly.RecommendForMultipleDrinks.recommendMaxAbvAndNumberOfDrinks
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecommendForMultipleDrinksTest {

    @Test
    internal fun `recommend 1 can at 3% abv for 1 unit in 330ml cans`() {
        val recommendations = recommendMaxAbvAndNumberOfDrinks(AvailableDrinks.can330, 1.0)

        println(recommendations)

        assertThat(recommendations.getNth(1).numberOfDrinks).isCloseTo(1.0, within(0.0))
        assertThat(recommendations.getNth(1).abv).isCloseTo(3.0, within(0.1))
    }

    @Test
    internal fun `recommend 2 cans at 1,5% abv for 1 unit in 330ml cans`() {
        val recommendations = recommendMaxAbvAndNumberOfDrinks(AvailableDrinks.can330, 1.0)

        println(recommendations)

        assertThat(recommendations.getNth(2).numberOfDrinks).isCloseTo(2.0, within(0.0))
        assertThat(recommendations.getNth(2).abv).isCloseTo(1.5, within(0.1))
    }

    @Test
    internal fun `recommend 1 can at 6% abv for 2 units in 330ml cans`() {
        val recommendations = recommendMaxAbvAndNumberOfDrinks(AvailableDrinks.can330, 2.0)

        println(recommendations)

        assertThat(recommendations.getNth(1).numberOfDrinks).isCloseTo(1.0, within(0.0))
        assertThat(recommendations.getNth(1).abv).isCloseTo(6.0, within(0.1))
    }

    @Test
    internal fun `recommend 2 cans at 3% abv for 2 units in 330ml cans`() {
        val recommendations = recommendMaxAbvAndNumberOfDrinks(AvailableDrinks.can330, 2.0)

        println(recommendations)

        assertThat(recommendations.getNth(2).numberOfDrinks).isCloseTo(2.0, within(0.0))
        assertThat(recommendations.getNth(2).abv).isCloseTo(3.0, within(0.1))
    }

    @Test
    internal fun `recommend 1 metric pint at 4% abv for 2 units in metric pints`() {
        val recommendations = recommendMaxAbvAndNumberOfDrinks(AvailableDrinks.metricPint, 2.0)

        println(recommendations)

        assertThat(recommendations.getNth(1).numberOfDrinks).isCloseTo(1.0, within(0.0))
        assertThat(recommendations.getNth(1).abv).isCloseTo(4.0, within(0.1))
    }

    @Test
    internal fun `do not recommend 9 metric pints at 0,4% abv (below minimum) for 2 units in metric pints`() {
        val recommendations = recommendMaxAbvAndNumberOfDrinks(AvailableDrinks.metricPint, 2.0)

        println(recommendations)

        assertThat(recommendations.getNth(8).abv).isGreaterThanOrEqualTo(0.5)
        assertThat(recommendations.size).isLessThanOrEqualTo(16)
    }

}