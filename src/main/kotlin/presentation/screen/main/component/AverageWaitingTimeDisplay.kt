package presentation.screen.main.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.resource.Color

@Composable
fun AverageWaitingTimeDisplay(
    nonPreemptiveAverageWaitingTimeExpression: String,
    preemptiveAverageWaitingTimeExpression: String
) {
    Card(
        backgroundColor = Color.DarkerBlueCyanAlpha70,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(all = 32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(all = 32.dp)
        ) {
            Text(
                text = "Average Waiting Time:",
                color = Color.White,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            AverageWaitingTimeExpressionDisplay(
                title = "Non-preemptive SJF: ",
                expression = nonPreemptiveAverageWaitingTimeExpression
            )
            AverageWaitingTimeExpressionDisplay(
                title = "Preemptive SJF: ",
                expression = preemptiveAverageWaitingTimeExpression
            )
        }
    }
}

@Composable
fun AverageWaitingTimeExpressionDisplay(title: String, expression: String) {
    Row(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = expression,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        )
    }
}