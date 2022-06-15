package presentation.util

import org.jetbrains.skia.impl.Log
import presentation.viewmodel.state.ProcessInput

data class ProcessInputValidator(val process: ProcessInput) {

    val isInputValid
        get() = isProcessNameIsNotEmpty()
                && isProcessNameLengthLessThan5()
                && isTextOnlyContainsNumber(input = process.arrivalTime)
                && isTextOnlyContainsNumber(input = process.burstTime)
                && isArrivalTimeLessThan20()
                && isBurstTimeLessThan10()
                && isBurstTimeBiggerThan0()


    fun isTextOnlyContainsNumber(input: String): Boolean {
        return if (input.trim().matches(Regex(pattern = "[0-9]+"))) true
        else {
            Log.error("$input must only contains number.")
            false
        }
    }


    private fun isProcessNameLengthLessThan5(): Boolean {
        return if (process.name.trim().length < 5) true
        else {
            Log.error("Process's name length must less than 5.")
            false
        }
    }

    private fun isProcessNameIsNotEmpty(): Boolean {
        return if (process.name.trim().isNotEmpty()) true
        else {
            Log.error("Process's name can't be empty.")
            false
        }
    }


    private fun isArrivalTimeLessThan20(): Boolean {
        return if (process.arrivalTime.toInt() < 20) true
        else {
            Log.error("Arrival time must less than 20.")
            false
        }
    }


    private fun isBurstTimeLessThan10(): Boolean {
        return if (process.burstTime.toInt() < 10) true
        else {
            Log.error("Burst time must less than 10.")
            false
        }
    }


    private fun isBurstTimeBiggerThan0(): Boolean {
        return if (process.burstTime.toInt() > 0) true
        else {
            Log.error("Burst time must bigger than 0.")
            false
        }
    }

}