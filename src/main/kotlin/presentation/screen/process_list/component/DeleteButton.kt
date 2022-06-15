package presentation.screen.process_list.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import presentation.resource.Color

@Composable
fun DeleteButton(deleteOnClick: () -> Unit) {
    Button(
        onClick = deleteOnClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
        contentPadding = PaddingValues(all = 4.dp),
        modifier = Modifier.size(30.dp)
    ) {
        Text(
            text = "X",
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }
}