package presentation.util

import org.jetbrains.skia.impl.Log
import presentation.viewmodel.state.ProcessInput

data class ProcessInputListValidator(val processInputList: List<ProcessInput>) {

    val result
        get() = isProcessListIsNotEmpty()
                && isThereOneAndOnlyOneProcessHasArrivalTimeEquals0()
                && isTotalProcessLessThan6()
                && isEachProcessHasDifferentArrivalTime()
                && isEachProcessHasDifferentName()


    private fun isTotalProcessLessThan6(): Boolean {
        return if (processInputList.count() < 6) true
        else {
            Log.error("Total number of process must less than 6.")
            false
        }
    }


    private fun isProcessListIsNotEmpty(): Boolean {
        return if (processInputList.isNotEmpty()) true
        else {
            Log.error("Process list can't be empty.")
            false
        }
    }


    private fun isThereOneAndOnlyOneProcessHasArrivalTimeEquals0(): Boolean {
        val processList = processInputList.filter { it.arrivalTime.toInt() == 0 }
        return if (processList.count() == 1) true
        else {
            Log.error("Must have one and only one process which start at 0 ms")
            false
        }
    }


    private fun isEachProcessHasDifferentArrivalTime(): Boolean {
        val processList = processInputList.sortedBy { it.arrivalTime.toInt() }
        var arrivalTime = -1
        for (process in processList) {
            if (arrivalTime != process.arrivalTime.toInt()) arrivalTime = process.arrivalTime.toInt()
            else {
                Log.error("Each process must have different arrival time.")
                return false
            }
        }

        return true
    }


    private fun isEachProcessHasDifferentName(): Boolean {
        val processList = processInputList.sortedBy { it.name }
        var name = ""
        for (process in processList) {
            if (name != process.name) name = process.name
            else {
                Log.error("Each process must have different name.")
                return false
            }
        }

        return true
    }

}
