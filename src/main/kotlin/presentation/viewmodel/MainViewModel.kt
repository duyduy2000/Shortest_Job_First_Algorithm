package presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.algorithm.NonPreemptiveSjfAlgorithm
import domain.algorithm.PreemptiveSjfAlgorithm
import presentation.util.ProcessInputListValidator
import presentation.viewmodel.state.AlgorithmResult
import presentation.viewmodel.state.AlgorithmResultUiState
import presentation.viewmodel.state.ProcessInput
import presentation.viewmodel.state.ProcessListUiState

class MainViewModel {
    val processList get() = processListUiState.processList
    private lateinit var nonPreemptiveSjfAlgorithm : NonPreemptiveSjfAlgorithm
    private lateinit var preemptiveSjfAlgorithm : PreemptiveSjfAlgorithm

    val nonPreemptiveSjfAlgorithmResult get() = algorithmResultUiState.nonPreemptiveSjfAlgorithmResult
    val preemptiveSjfAlgorithmResult get() = algorithmResultUiState.preemptiveSjfAlgorithmResult

    var processListUiState by mutableStateOf(value = ProcessListUiState())
        private set
    private var algorithmResultUiState by mutableStateOf(value = AlgorithmResultUiState())


    fun executeAlgorithms() {
        if (isProcessInputListValid()) {
            mapAllProcessInputToProcess()
            nonPreemptiveSjfAlgorithm = NonPreemptiveSjfAlgorithm(input = processList)
            preemptiveSjfAlgorithm = PreemptiveSjfAlgorithm(input = processList)

            nonPreemptiveSjfAlgorithm.execute()
            preemptiveSjfAlgorithm.execute()

            algorithmResultUiState = algorithmResultUiState.copy(
                nonPreemptiveSjfAlgorithmResult = AlgorithmResult(
                    totalExecutionTime = nonPreemptiveSjfAlgorithm.processList.totalExecutionTime,
                    averageWaitingTimeExpression = nonPreemptiveSjfAlgorithm.averageWaitingTimeExpression,
                    executionResultList = nonPreemptiveSjfAlgorithm.processExecutionTimeStampList
                ),
                preemptiveSjfAlgorithmResult = AlgorithmResult(
                    totalExecutionTime = preemptiveSjfAlgorithm.processList.totalExecutionTime,
                    averageWaitingTimeExpression = preemptiveSjfAlgorithm.averageWaitingTimeExpression,
                    executionResultList = preemptiveSjfAlgorithm.processExecutionTimeStampList
                )
            )
        }
    }


    fun addProcessInput(processInput: ProcessInput) {
        val newList = processListUiState.processInputList + processInput
        processListUiState = processListUiState.copy(processInputList = newList)
    }


    fun deleteProcessInputByIndex(index: Int) {
        val newList = processListUiState.processInputList.toMutableList()
        newList.removeAt(index)
        processListUiState = processListUiState.copy(processInputList = newList)
    }


    private fun isProcessInputListValid(): Boolean {
        val validator = ProcessInputListValidator(processInputList = processListUiState.processInputList)
        return validator.result
    }


    private fun mapAllProcessInputToProcess() {
        val processList = processListUiState.processInputList.map { it.toProcess() }
        processListUiState = processListUiState.copy(processList = processList)
    }

}