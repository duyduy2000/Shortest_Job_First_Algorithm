package domain.calculator

import domain.model.Process
import domain.model.ProcessList
import domain.util.MilliSeconds

class PreemptiveAverageWaitingTimeCalculator(
    val processExecutionTimeStampList: List<ProcessExecutionTimeStamp>,
    val processList: ProcessList,
) : ProcessAverageWaitingTimeCalculator(processExecutionTimeStampList, processList) {

    private val processExecutionResultList = mutableListOf<ProcessExecutionResult>()
    private val totalExecutionTime get() = processList.totalExecutionTime

    override fun getAverageWaitingTimeExpression(): String {
        getResultList()
        var resultLeftSide = ""
        var averageWaitingTime = 0f

        for (result in processExecutionResultList) {
            resultLeftSide += "${result.name} (${result.completionTime.value} - ${result.arrivalTime.value} - ${result.burstTime.value}) + "
            averageWaitingTime += result.completionTime.value - result.arrivalTime.value - result.burstTime.value
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
            val processExecutionResult = processExecutionTimeStampList.findLast { it.name == process.name }
            val nextProcessIndex = processExecutionTimeStampList.indexOf(processExecutionResult!!) + 1

            if (nextProcessIndex < processExecutionTimeStampList.count()) {
                val nextProcess = processExecutionTimeStampList[nextProcessIndex]
                addProcessExecutionResult(
                    process = process,
                    completionTime = nextProcess.startExecutionTimeStamp
                )
            } else {
                addProcessExecutionResult(
                    process = process,
                    completionTime = totalExecutionTime
                )
            }
        }
    }


    private fun addProcessExecutionResult(process: Process, completionTime: MilliSeconds) {
        processExecutionResultList.add(
            ProcessExecutionResult(
                name = process.name,
                arrivalTime = process.arrivalTime,
                burstTime = process.burstTime,
                completionTime = completionTime
            )
        )
    }


    data class ProcessExecutionResult(
        val name: String,
        val arrivalTime: MilliSeconds,
        val burstTime: MilliSeconds,
        val completionTime: MilliSeconds
    )

}