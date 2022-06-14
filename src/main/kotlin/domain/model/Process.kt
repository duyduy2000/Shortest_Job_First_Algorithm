package domain.model

import domain.util.MilliSeconds

data class Process(
    val name: String,
    val arrivalTime: MilliSeconds,
    val burstTime: MilliSeconds
) {
    fun toExecutedProcess() = ExecutedProcess(
        name = name,
        remainingBurstTime = burstTime
    )
}


data class ExecutedProcess(
    val name: String,
    val remainingBurstTime: MilliSeconds
)
