package presentation.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.calculator.ProcessExecutionTimeStamp
import domain.util.MilliSeconds
import presentation.resource.Color

@Composable
fun ProcessExecutionTimeStampDisplay(timeStampList: List<ProcessExecutionTimeStamp>, totalExecutionTime: MilliSeconds) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
            .padding(vertical = 16.dp)
    ) {
        for (timeStamp in timeStampList) {
            TimeStampDisplay(milliSeconds = timeStamp.startExecutionTimeStamp)
            RunningProcessDisplay(processName = timeStamp.name)
        }
        TimeStampDisplay(milliSeconds = totalExecutionTime)
    }
}
