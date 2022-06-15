package presentation.screen.process_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.resource.Color
import presentation.screen.process_list.component.AddProcessBar
import presentation.screen.process_list.component.ProcessListHeader
import presentation.screen.process_list.component.TableRow
import presentation.viewmodel.MainViewModel

@Composable
fun ProcessListScreen(mainViewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkBlueCyan)
    ) {
        ProcessListHeader(executeAlgorithmOnButtonClick = { mainViewModel.executeAlgorithms() })

        ProcessInputList(mainViewModel = mainViewModel)

        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent)) {
            AddProcessBar(addProcessAfterValidation = { mainViewModel.addProcessInput(it) })
        }
    }
}

@Composable
fun ProcessInputList(mainViewModel: MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f)
            .background(Color.Transparent)
            .padding(all = 16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight()
        ) {
            itemsIndexed(items = mainViewModel.processListUiState.processInputList) { index, process ->
                run {
                    TableRow(
                        process = process,
                        backgroundColor = Color.DarkerBlueCyanAlpha70,
                        deleteOnButtonClick = { mainViewModel.deleteProcessInputByIndex(index) }
                    )
                }
            }
        }
    }
}
