package domain.model

import domain.util.MilliSeconds
import domain.util.MilliSeconds.Companion.ms

data class ProcessList(val list: List<Process>) {
    var totalExecutedProcess = 0
    var totalExecutionTime: MilliSeconds
    val count get() = list.count()
    private var shortestArrivalTime = (-1).ms

    init {
        totalExecutionTime = MilliSeconds(value = list.sumOf { it.burstTime.value })
    }

    fun getShortestArrivalTimeProcess(): Process? {
        val tempList = list.filter { it.arrivalTime > shortestArrivalTime }
        val shortestArrivalTimeProcess = tempList.minByOrNull { it.arrivalTime.value }
        if (shortestArrivalTimeProcess != null) shortestArrivalTime = shortestArrivalTimeProcess.arrivalTime
        return shortestArrivalTimeProcess
    }

}