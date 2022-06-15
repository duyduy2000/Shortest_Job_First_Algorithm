package presentation.screen.process_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import presentation.resource.Color
import presentation.viewmodel.state.ProcessInput
import presentation.util.ProcessInputValidator

@Composable
fun AddProcessBar(addProcessAfterValidation: (ProcessInput) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(Color.DarkerBlueCyanAlpha30)) {
        val name = remember { mutableStateOf("") }
        val arrivalTime = remember { mutableStateOf("") }
        val burstTime = remember { mutableStateOf("") }
        val emptyTextOnButtonClick = {
            name.value = ""
            arrivalTime.value = ""
            burstTime.value = ""
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color.Transparent)
                .padding(horizontal = 8.dp)
        ) {
            ProcessInputTextField(
                title = "Name",
                value = name.value,
                onValueChange = { name.value = it }
            )
            ProcessInputTextField(
                title = "Arrival time",
                value = arrivalTime.value,
                onValueChange = { arrivalTime.value = it }
            )
            ProcessInputTextField(
                title = "Burst time",
                value = burstTime.value,
                onValueChange = { burstTime.value = it }
            )
        }

        AddProcessButton(
            name = name.value,
            arrivalTime = arrivalTime.value,
            burstTime = burstTime.value,
            emptyTextOnButtonClick = emptyTextOnButtonClick,
            addProcess = addProcessAfterValidation,
            modifier = Modifier.fillMaxSize().background(Color.Transparent)
        )
    }
}

@Composable
fun ProcessInputTextField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentSize()
    ) {
        Text(
            text = "$title:",
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier.height(50.dp).width(80.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun AddProcessButton(
    name: String,
    arrivalTime: String,
    burstTime: String,
    addProcess: (ProcessInput) -> Unit,
    emptyTextOnButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Button(
            modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            onClick = {
                val processInput = ProcessInput(
                    name = name.trim(),
                    arrivalTime = arrivalTime.trim(),
                    burstTime = burstTime.trim()
                )
                val validator = ProcessInputValidator(process = processInput)
                if (validator.isInputValid) {
                    addProcess(processInput)
                    emptyTextOnButtonClick()
                }
            }
        ) {
            Text(
                text = "+ ADD PROCESS",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
