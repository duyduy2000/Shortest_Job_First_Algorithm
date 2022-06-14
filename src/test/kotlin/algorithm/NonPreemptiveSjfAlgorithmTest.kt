package algorithm

import domain.algorithm.NonPreemptiveSjfAlgorithm
import domain.model.Process
import domain.util.MilliSeconds.Companion.ms
import domain.util.fakeProcessList1
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

class NonPreemptiveSjfAlgorithmTest {

    private lateinit var processList: List<Process>
    private lateinit var algorithmTest: NonPreemptiveSjfAlgorithm

    @Before
    fun setUp() {
        processList = fakeProcessList1
        algorithmTest = NonPreemptiveSjfAlgorithm(input = processList.toMutableList())
    }

    @Test
    fun `first process executed at 0 ms`() {
        algorithmTest.execute()
        val result = algorithmTest.processExecutionTimeStampList.first().startExecutionTimeStamp
        assertEquals(expected = 0.ms, actual = result)
    }


}