package presentation.screen.process_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import domain.model.Process
import presentation.resource.Color
import androidx.compose.ui.graphics.Color as ComposeUiGraphicsColor

@Composable
fun ProcessTableList(processList: List<Process>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight()
    ) {
        items(items = processList) { TableRow(process = it, backgroundColor = Color.DarkerBlueCyanAlpha70) }
    }
}

@Composable
fun TableRow(process: Process, backgroundColor: ComposeUiGraphicsColor) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(backgroundColor)
                .padding(8.dp)
        ) {
            ProcessNameDisplay(processName = process.name)
            ProcessArrivalTimeAndBurstTimeDisplay(
                arrivalTime = process.arrivalTime,
                burstTime = process.burstTime
            )
        }
    }
}

