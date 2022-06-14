package domain.calculator

import domain.model.ProcessList

abstract class ProcessAverageWaitingTimeCalculator(
    private val processExecutionTimeStampList: List<ProcessExecutionTimeStamp>,
    private val processList: ProcessList
) {
    abstract fun getAverageWaitingTimeExpression(): String
    abstract fun getResultList()
}
