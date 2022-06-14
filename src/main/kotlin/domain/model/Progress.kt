package domain.model

import domain.util.MilliSeconds

data class Progress(
    var timeStamp: MilliSeconds,
    var currentRunningProcess: ExecutedProcess? = null,
    val waitingProcessQueue: WaitingProcessQueue
) {

    fun updateNewRunningProcess(currentTimeStamp: MilliSeconds, process: ExecutedProcess) {
        timeStamp = currentTimeStamp
        currentRunningProcess = ExecutedProcess(
            name = process.name,
            remainingBurstTime = MilliSeconds(value = process.remainingBurstTime.value)
        )
    }

}