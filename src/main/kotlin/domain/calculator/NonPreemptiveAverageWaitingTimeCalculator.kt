package domain.calculator

import domain.model.Process
import domain.model.ProcessList
import domain.util.MilliSeconds

class NonPreemptiveAverageWaitingTimeCalculator(
    val processExecutionTimeStampList: List<ProcessExecutionTimeStamp>,
    val processList: ProcessList
) : ProcessAverageWaitingTimeCalculator(processExecutionTimeStampList, processList) {

    private val processExecutionResultList = mutableListOf<ProcessExecutionResult>()

    override fun getAverageWaitingTimeExpression(): String {
        getResultList()
        var resultLeftSide = ""
        var averageWaitingTime = 0f

        for (result in processExecutionResultList) {
            resultLeftSide += "${result.name} (${result.startExecutedTimeStamp.value} - ${result.arrivalTime.value}) + "
            averageWaitingTime += result.startExecutedTimeStamp.value - result.arrivalTime.value
        }

        resultLeftSide = resultLeftSide.substring(startIndex = 0, endIndex = resultLeftSide.length - 2) +
                "= $averageWaitingTime / ${processList.count}"
        return String.format(
            "%s = %.1f",
            resultLeftSide,
            averageWaitingTime / processList.count
        )
    }


    override fun getResultList() {
        for (process in processList.list) {
            val processExecutionResult = processExecutionTimeStampList.find { it.name == process.name }
            addProcessExecutionResult(
                process = process,
                startExecuted = processExecutionResult!!.startExecutionTimeStamp
            )
        }
    }


    private fun addProcessExecutionResult(process: Process, startExecuted: MilliSeconds) {
        processExecutionResultList.add(
            ProcessExecutionResult(
                name = process.name,
                arrivalTime = process.arrivalTime,
                startExecutedTimeStamp = startExecuted
            )
        )
    }

    data class ProcessExecutionResult(
        val name: String,
        val arrivalTime: MilliSeconds,
        val startExecutedTimeStamp: MilliSeconds
    )
}