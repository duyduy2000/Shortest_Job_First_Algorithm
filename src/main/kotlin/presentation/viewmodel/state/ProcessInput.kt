package presentation.viewmodel.state

import domain.model.Process
import domain.util.MilliSeconds

data class ProcessInput(
    var name: String,
    var arrivalTime: String,
    var burstTime: String
) {
    fun toProcess() = Process(
        name = name,
        arrivalTime = MilliSeconds(value = arrivalTime.toInt()),
        burstTime = MilliSeconds(value = burstTime.toInt())
    )
}