package presentation.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.util.MilliSeconds
import presentation.resource.Color

@Composable
fun TimeStampDisplay(milliSeconds: MilliSeconds) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.wrapContentSize().offset(y = 22.dp)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(shape = CircleShape)
                .background(Color.White)
        )
        Text(
            text = milliSeconds.value.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun RunningProcessDisplay(processName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.wrapContentSize()
    ) {
        Text(
            text = processName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.wrapContentSize()
        )
        HorizontalWhiteLine(height = 2.dp, width = 70.dp)
    }
}