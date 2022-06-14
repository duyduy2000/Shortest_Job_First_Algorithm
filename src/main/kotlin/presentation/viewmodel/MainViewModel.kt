package presentation.viewmodel

import domain.algorithm.NonPreemptiveSjfAlgorithm
import domain.algorithm.PreemptiveSjfAlgorithm
import domain.calculator.ProcessExecutionTimeStamp
import domain.model.Process
import domain.util.MilliSeconds
import domain.util.MilliSeconds.Companion.ms

class MainViewModel(val processList: List<Process>) {

    private val nonPreemptiveSjfAlgorithm = NonPreemptiveSjfAlgorithm(input = processList)
    private val preemptiveSjfAlgorithm = PreemptiveSjfAlgorithm(input = processList)

    var nonPreemptiveSjfAlgorithmResult = AlgorithmResult(
        totalExecutionTime = 0.ms,
        averageWaitingTimeExpression = "0",
        executionResultList = emptyList()
    )
    var preemptiveSjfAlgorithmResult = AlgorithmResult(
        totalExecutionTime = 0.ms,
        averageWaitingTimeExpression = "0",
        executionResultList = emptyList()
    )


    fun executeAlgorithms() {
        nonPreemptiveSjfAlgorithm.execute()
        preemptiveSjfAlgorithm.execute()

        nonPreemptiveSjfAlgorithmResult = AlgorithmResult(
            totalExecutionTime = nonPreemptiveSjfAlgorithm.processList.totalExecutionTime,
            averageWaitingTimeExpression = nonPreemptiveSjfAlgorithm.averageWaitingTimeExpression,
            executionResultList = nonPreemptiveSjfAlgorithm.processExecutionTimeStampList
        )
        preemptiveSjfAlgorithmResult = AlgorithmResult(
            totalExecutionTime = preemptiveSjfAlgorithm.processList.totalExecutionTime,
            averageWaitingTimeExpression = preemptiveSjfAlgorithm.averageWaitingTimeExpression,
            executionResultList = preemptiveSjfAlgorithm.processExecutionTimeStampList
        )
    }


    data class AlgorithmResult(
        val totalExecutionTime: MilliSeconds,
        val averageWaitingTimeExpression: String,
        val executionResultList: List<ProcessExecutionTimeStamp>
    )
}