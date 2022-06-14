package core

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import domain.util.fakeProcessList1
import presentation.screen.main.MainScreen
import presentation.screen.process_list.ProcessListScreen
import presentation.viewmodel.MainViewModel

@Composable
fun MainWindow(onClose: () -> Unit, title: String, viewModel: MainViewModel) {
    Window(
        onCloseRequest = onClose,
        title = title,
        state = WindowState(width = 1500.dp, height = 800.dp)
    ) {
        MainScreen(viewModel = viewModel)
    }
}

@Composable
fun ProcessListWindow(onClose: () -> Unit, title: String, viewModel: MainViewModel) {
    Window(
        onCloseRequest = onClose,
        title = title,
        state = WindowState(width = 500.dp, height = 800.dp)
    ) {
        ProcessListScreen(viewModel = viewModel)
    }
}

fun main() = application {
    val viewModel = MainViewModel(processList = fakeProcessList1)

    MainWindow(
        onClose = ::exitApplication,
        title = "Shortest-Job-First Algorithm",
        viewModel = viewModel
    )

    ProcessListWindow(
        onClose = ::exitApplication,
        title = "Process list",
        viewModel = viewModel
    )

}
