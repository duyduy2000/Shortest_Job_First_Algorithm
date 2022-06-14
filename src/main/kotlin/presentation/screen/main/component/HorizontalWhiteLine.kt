package presentation.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import presentation.resource.Color

@Composable
fun HorizontalWhiteLine(height: Dp, width: Dp) {
    Box(modifier = Modifier
        .height(height)
        .width(width)
        .background(Color.White)
    )
}