package presentation.screen.process_list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.resource.Color

@Composable
fun ProcessListHeader(executeAlgorithmOnButtonClick: () -> Unit) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = "Process List",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.WhiteAlpha70,
            modifier = Modifier.wrapContentSize().padding(16.dp)
        )
        Spacer(modifier = Modifier.width(210.dp))
        Button(
            onClick = executeAlgorithmOnButtonClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier.wrapContentSize().padding(top = 8.dp)
        ) {
            Text(
                text = "EXECUTE",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}