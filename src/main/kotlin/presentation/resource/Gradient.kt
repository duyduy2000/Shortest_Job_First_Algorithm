package presentation.resource

import androidx.compose.ui.graphics.Brush

object Gradient {

    val DarkGrayGradient = Brush.radialGradient(
        colors = listOf(
            Color.DarkGray,
            Color.Black
        )
    )

    val DarkGreenGradient = Brush.radialGradient(
        colorStops = arrayOf(
            .0f to Color.DarkGreen,
            1f to Color.Black
        ),
        radius = 40f
    )

    val BlueAndCyanGradient = Brush.verticalGradient(
        colorStops = arrayOf(
            .0f to Color.Cyan,
            .3f to Color.BlueCyan,
        )
    )


}