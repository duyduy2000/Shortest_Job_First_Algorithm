package presentation.screen.process_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.resource.Color
import presentation.viewmodel.state.ProcessInput
import androidx.compose.ui.graphics.Color as ComposeUiGraphicsColor

@Composable
fun TableRow(
    process: ProcessInput,
    backgroundColor: ComposeUiGraphicsColor,
    deleteOnButtonClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(backgroundColor)
            .clip(shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        ProcessNameDisplay(processName = process.name)
        ProcessArrivalTimeAndBurstTimeDisplay(arrivalTime = process.arrivalTime, burstTime = process.burstTime)
        DeleteButton(deleteOnClick = deleteOnButtonClick)
    }
}

@Composable
fun ProcessNameDisplay(processName: String) {
    Column(modifier = Modifier.fillMaxSize(0.4f)) {
        Text(
            text = "Name",
            color = Color.WhiteAlpha70,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = processName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}


@Composable
fun ProcessArrivalTimeAndBurstTimeDisplay(arrivalTime: String, burstTime: String) {
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f)) {
        ProcessTimerDisplay(
            timerName = "Arrival Time",
            timerValue = arrivalTime,
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProcessTimerDisplay(
            timerName = "Burst Time",
            timerValue = burstTime,
        )
    }
}


@Composable
fun ProcessTimerDisplay(timerName: String, timerValue: String) {
    Row(modifier = Modifier.wrapContentSize()) {
        Text(
            text = "$timerName:",
            fontStyle = FontStyle.Italic,
            color = Color.WhiteAlpha70
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$timerValue ms",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

