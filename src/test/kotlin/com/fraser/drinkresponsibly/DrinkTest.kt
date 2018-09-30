package com.fraser.drinkresponsibly

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DrinkTest {

    @Test
    internal fun `drink has same name and size as set by constructor`() {
        val bottle = Drink("Bottle", 275.0)
        assertThat(bottle.name).isEqualTo("Bottle")
        assertThat(bottle.size).isEqualTo(275.0)
    }
}