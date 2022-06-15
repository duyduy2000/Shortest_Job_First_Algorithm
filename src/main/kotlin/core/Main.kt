package core

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import presentation.screen.main.MainScreen
import presentation.screen.process_list.ProcessListScreen
import presentation.viewmodel.MainViewModel

@Composable
fun MainWindow(onClose: () -> Unit, title: String, mainViewModel: MainViewModel) {
    Window(
        onCloseRequest = onClose,
        title = title,
        state = WindowState(width = 1500.dp, height = 800.dp)
    ) {
        MainScreen(viewModel = mainViewModel)
    }
}

@Composable
fun ProcessListWindow(onClose: () -> Unit, title: String, mainViewModel: MainViewModel) {
    Window(
        onCloseRequest = onClose,
        resizable = false,
        title = title,
        state = WindowState(width = 500.dp, height = 800.dp)
    ) {
        ProcessListScreen(mainViewModel = mainViewModel)
    }
}

fun main() = application {
    val mainViewModel = MainViewModel()

    MainWindow(
        onClose = ::exitApplication,
        title = "Shortest-Job-First Algorithm",
        mainViewModel = mainViewModel
    )

    ProcessListWindow(
        onClose = ::exitApplication,
        title = "Process list",
        mainViewModel = mainViewModel
    )

}
