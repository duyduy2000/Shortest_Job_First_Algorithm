package presentation.viewmodel.state

import domain.calculator.ProcessExecutionTimeStamp
import domain.util.MilliSeconds

data class AlgorithmResult(
    val totalExecutionTime: MilliSeconds,
    val averageWaitingTimeExpression: String,
    val executionResultList: List<ProcessExecutionTimeStamp>
)
