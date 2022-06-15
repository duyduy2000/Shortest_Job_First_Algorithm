package other

import domain.model.ProcessList
import domain.util.fakeProcessList1
import org.junit.Before
import presentation.viewmodel.state.ProcessInput
import kotlin.test.Test
import kotlin.test.assertEquals

class ProcessListTest {

    private lateinit var processList: ProcessList
    private lateinit var processInput: ProcessInput

    @Before
    fun setUp() {
        processList = ProcessList(fakeProcessList1)
        processInput = ProcessInput(name = "P1", arrivalTime = "0", burstTime = "1")
    }

    @Test
    fun `process has shortest arrival time is P4`() {
        val result = processList.getShortestArrivalTimeProcess()
        assertEquals(expected = false, actual = processList.list.contains(result))
    }

}