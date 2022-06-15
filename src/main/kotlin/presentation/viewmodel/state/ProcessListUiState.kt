package presentation.viewmodel.state

import domain.model.Process

data class ProcessListUiState(
    val processList: List<Process> = emptyList(),
    val processInputList: List<ProcessInput> = emptyList()
)
