package domain.algorithm

import domain.calculator.PreemptiveAverageWaitingTimeCalculator
import domain.model.Process
import domain.util.MilliSeconds.Companion.ms

class PreemptiveSjfAlgorithm(input: List<Process>) : ShortestJobFirstAlgorithm(input) {

    private var nextShortestArrivalTimeProcess: Process? = null

    override fun execute() {
        updateProgressAt0ms()
        processList.totalExecutedProcess = 0
        nextShortestArrivalTimeProcess = processList.getShortestArrivalTimeProcess()

        while (processList.totalExecutedProcess < processList.count) {
            currentProgress.timeStamp++
            advanceCurrentProcessFor1ms()

            val isNextProcessArrived = nextShortestArrivalTimeProcess != null
                    && currentProgress.timeStamp == nextShortestArrivalTimeProcess!!.arrivalTime
            val isCurrentProcessFinished = currentProgress.currentRunningProcess != null
                    && currentProgress.currentRunningProcess!!.remainingBurstTime == 0.ms
                    || currentProgress.currentRunningProcess == null

            if (isNextProcessArrived) {
                if (
                    currentProgress.currentRunningProcess != null
                    && nextShortestArrivalTimeProcess!!.burstTime < currentProgress.currentRunningProcess!!.remainingBurstTime
                ) {
                    currentProgress.waitingProcessQueue.add(currentProgress.currentRunningProcess!!)
                    updateNewRunningProcess(process = nextShortestArrivalTimeProcess!!.toExecutedProcess())
                } else {
                    currentProgress.waitingProcessQueue.add(nextShortestArrivalTimeProcess!!)
                }

                nextShortestArrivalTimeProcess = processList.getShortestArrivalTimeProcess()
            }

            if (isCurrentProcessFinished) {
                currentProgress.currentRunningProcess = null
                processList.totalExecutedProcess++
                if (!currentProgress.waitingProcessQueue.isEmpty()) {
                    updateNewRunningProcess(process = currentProgress.waitingProcessQueue.getShortestBurstTimeProcess())
                }
            }
        }

        processList.totalExecutionTime = currentProgress.timeStamp
        calculateAverageWaitingTime()
        printResultToLogcat()
    }


    override fun calculateAverageWaitingTime() {
        val calculator = PreemptiveAverageWaitingTimeCalculator(
            processExecutionTimeStampList = processExecutionTimeStampList,
            processList = processList
        )
        averageWaitingTimeExpression = calculator.getAverageWaitingTimeExpression()
    }

}