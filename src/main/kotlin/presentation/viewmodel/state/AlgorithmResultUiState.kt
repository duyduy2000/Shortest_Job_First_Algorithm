package presentation.viewmodel.state

import domain.util.MilliSeconds.Companion.ms

data class AlgorithmResultUiState(
    val nonPreemptiveSjfAlgorithmResult: AlgorithmResult = AlgorithmResult(
        totalExecutionTime = 0.ms,
        averageWaitingTimeExpression = "0",
        executionResultList = emptyList()
    ),
    val preemptiveSjfAlgorithmResult: AlgorithmResult = AlgorithmResult(
        totalExecutionTime = 0.ms,
        averageWaitingTimeExpression = "0",
        executionResultList = emptyList()
    )
)
