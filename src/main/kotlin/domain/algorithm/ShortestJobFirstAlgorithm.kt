package domain.algorithm

import domain.calculator.ProcessExecutionTimeStamp
import domain.model.*
import domain.util.MilliSeconds
import domain.util.MilliSeconds.Companion.ms
import org.jetbrains.skia.impl.Log

abstract class ShortestJobFirstAlgorithm(input: List<Process>) {
    val processList = ProcessList(input)
    lateinit var currentProgress: Progress

    var averageWaitingTimeExpression = ""
        protected set

    private val _processExecutionTimeStampList = mutableListOf<ProcessExecutionTimeStamp>()
    val processExecutionTimeStampList: List<ProcessExecutionTimeStamp> get() = _processExecutionTimeStampList

    abstract fun execute()
    abstract fun calculateAverageWaitingTime()


    fun updateProgressAt0ms() {
        val currentProcess = processList.getShortestArrivalTimeProcess()!!
        currentProgress = Progress(
            timeStamp = 0.ms,
            currentRunningProcess = ExecutedProcess(
                name = currentProcess.name,
                remainingBurstTime = MilliSeconds(value = currentProcess.burstTime.value)
            ),
            waitingProcessQueue = WaitingProcessQueue()
        )

        addProcessExecutionResult(processName = currentProcess.name)
    }


    protected fun updateNewRunningProcess(process: ExecutedProcess) {
        currentProgress.updateNewRunningProcess(
            process = process,
            currentTimeStamp = currentProgress.timeStamp
        )

        addProcessExecutionResult(processName = process.name)
    }


    protected fun advanceCurrentProcessFor1ms() {
        currentProgress.currentRunningProcess?.remainingBurstTime?.minusAssign(1.ms)
    }


    private fun addProcessExecutionResult(processName: String) = _processExecutionTimeStampList.add(
        ProcessExecutionTimeStamp(
            name = processName,
            startExecutionTimeStamp = MilliSeconds(value = currentProgress.timeStamp.value)
        )
    )


    protected fun printResultToLogcat() {
        for (result in processExecutionTimeStampList) {
            Log.warn("process ${result.name} started at ${result.startExecutionTimeStamp.value} ms")
        }
        Log.warn("Total execution time: ${processList.totalExecutionTime.value}\nAverage waiting time: $averageWaitingTimeExpression")
    }

}
