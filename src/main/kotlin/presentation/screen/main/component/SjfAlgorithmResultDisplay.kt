package presentation.screen.main.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.calculator.ProcessExecutionTimeStamp
import domain.util.MilliSeconds
import presentation.resource.Color

@Composable
fun SjfAlgorithmsResultDisplay(
    nonPreemptiveTimeStampList: List<ProcessExecutionTimeStamp>,
    preemptiveTimeStampList: List<ProcessExecutionTimeStamp>,
    nonPreemptiveTotalExecutionTime: MilliSeconds,
    preemptiveTotalExecutionTime: MilliSeconds
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(all = 32.dp)
    ) {
        AlgorithmExecutionResultDisplay(
            title = "Non-preemptive SJF Algorithm:",
            timeStampList = nonPreemptiveTimeStampList,
            totalExecutionTime = nonPreemptiveTotalExecutionTime
        )

        Spacer(modifier = Modifier.height(16.dp))

        AlgorithmExecutionResultDisplay(
            title = "Preemptive SJF Algorithm:",
            timeStampList = preemptiveTimeStampList,
            totalExecutionTime = preemptiveTotalExecutionTime
        )
    }
}

@Composable
fun AlgorithmExecutionResultDisplay(
    title: String,
    timeStampList: List<ProcessExecutionTimeStamp>,
    totalExecutionTime: MilliSeconds
) {
    Card(
        backgroundColor = Color.DarkerBlueCyanAlpha30,
        elevation = 0.dp,
        modifier = Modifier.wrapContentSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(all = 32.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            ProcessExecutionTimeStampDisplay(
                timeStampList = timeStampList,
                totalExecutionTime = totalExecutionTime
            )
        }
    }
}