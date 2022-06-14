package presentation.screen.process_list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.util.MilliSeconds
import presentation.resource.Color


@Composable
fun ProcessNameDisplay(processName: String) {
    Column(modifier = Modifier.fillMaxSize(0.5f)) {
        Text(
            text = "Name",
            color = Color.WhiteAlpha70,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = processName,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}


@Composable
fun ProcessArrivalTimeAndBurstTimeDisplay(arrivalTime: MilliSeconds, burstTime: MilliSeconds) {
    Column {
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
fun ProcessTimerDisplay(timerName: String, timerValue: MilliSeconds) {
    Row(modifier = Modifier.wrapContentSize()) {
        Text(
            text = "$timerName:",
            fontStyle = FontStyle.Italic,
            color = Color.WhiteAlpha70
        )
        Spacer(modifier = Modifier.width(4.dp))
        TextField(
            value = "",
            onValueChange = {

            }
        )
    }
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic, color = Color.WhiteAlpha70)) {
                append(timerName)
                append(":  ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.White)) {
                append("${timerValue.value} ms")
            }
        }
    )
}
