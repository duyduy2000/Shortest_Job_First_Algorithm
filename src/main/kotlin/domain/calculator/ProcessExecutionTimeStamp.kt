package domain.calculator

import domain.util.MilliSeconds

data class ProcessExecutionTimeStamp(
    val name: String,
    val startExecutionTimeStamp: MilliSeconds,
)
