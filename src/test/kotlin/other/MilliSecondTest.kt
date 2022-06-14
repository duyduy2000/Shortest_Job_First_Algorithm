package other

import domain.util.MilliSeconds.Companion.ms
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class MilliSecondTest {
    @Test
    fun `millis increment test`() {
        var result = 0.ms
        result++
        assertEquals(expected = 1.ms, actual = result)
    }


    @Test
    fun `millis equation`() {
        assertFalse { 0.ms == 1.ms }
    }

}