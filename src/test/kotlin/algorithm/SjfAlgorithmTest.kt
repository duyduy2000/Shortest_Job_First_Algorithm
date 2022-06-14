package algorithm

import domain.algorithm.NonPreemptiveSjfAlgorithm
import domain.util.fakeProcessList1
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SjfAlgorithmTest {

    private lateinit var algorithm: NonPreemptiveSjfAlgorithm

    @Before
    fun setUp() {
        algorithm = NonPreemptiveSjfAlgorithm(input = fakeProcessList1)
    }

    @Test
    fun `get process which start at 0 ms`() {
        algorithm.updateProgressAt0ms()

        val result = algorithm.currentProgress.currentRunningProcess!!
        assertEquals(expected = "P4", actual = result.name)
    }

}