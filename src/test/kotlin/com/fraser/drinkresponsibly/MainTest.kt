package com.fraser.drinkresponsibly

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {

    @Test
    internal fun `example test`() {
        assertThat(true).isTrue()
    }
}