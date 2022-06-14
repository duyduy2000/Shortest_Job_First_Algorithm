package presentation.screen.process_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.resource.Color
import presentation.screen.process_list.component.ProcessTableList
import presentation.viewmodel.MainViewModel

@Composable
fun ProcessListScreen(viewModel: MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkBlueCyan)
            .padding(all = 16.dp)
    ) {
        ProcessTableList(processList = viewModel.processList)
    }
}