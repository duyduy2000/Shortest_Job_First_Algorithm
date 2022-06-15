package other

import org.junit.Before
import presentation.viewmodel.state.ProcessInput
import presentation.util.ProcessInputValidator
import kotlin.test.Test
import kotlin.test.assertEquals

class TextInputValidatorText {

    private lateinit var processInputValidator: ProcessInputValidator
    private lateinit var input: ProcessInput

    @Before
    fun setUp() {
        input = ProcessInput(
            name = "P1",
            arrivalTime = "0",
            burstTime = "1"
        )
        processInputValidator = ProcessInputValidator(process = input)
    }

    @Test
    fun `arrival time input only contains number`() {
        input = input.copy(arrivalTime = "-1")
        assertEquals(
            expected = false,
            actual = processInputValidator.isTextOnlyContainsNumber(input = input.arrivalTime)
        )
    }

    @Test
    fun `process has invalid input`() {
        input = input.copy(
            name = "P2",
            arrivalTime = "15",
            burstTime = "1aaa1"
        )
        processInputValidator = ProcessInputValidator(process = input)
        assertEquals(expected = false, processInputValidator.isInputValid)
    }

}