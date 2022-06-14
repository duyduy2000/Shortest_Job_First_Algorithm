package presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.resource.Gradient
import presentation.screen.main.component.AverageWaitingTimeDisplay
import presentation.screen.main.component.SjfAlgorithmsResultDisplay
import presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Gradient.BlueAndCyanGradient)
    ) {
        SjfAlgorithmsResultDisplay(
            nonPreemptiveTimeStampList = viewModel.nonPreemptiveSjfAlgorithmResult.executionResultList,
            preemptiveTimeStampList = viewModel.preemptiveSjfAlgorithmResult.executionResultList,
            nonPreemptiveTotalExecutionTime = viewModel.nonPreemptiveSjfAlgorithmResult.totalExecutionTime,
            preemptiveTotalExecutionTime = viewModel.preemptiveSjfAlgorithmResult.totalExecutionTime
        )

        AverageWaitingTimeDisplay(
            nonPreemptiveAverageWaitingTimeExpression = viewModel.nonPreemptiveSjfAlgorithmResult.averageWaitingTimeExpression,
            preemptiveAverageWaitingTimeExpression = viewModel.preemptiveSjfAlgorithmResult.averageWaitingTimeExpression,
        )
    }
}