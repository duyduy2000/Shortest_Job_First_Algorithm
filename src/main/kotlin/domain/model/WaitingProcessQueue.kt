package domain.model

class WaitingProcessQueue {
    private val processList: MutableList<ExecutedProcess> = mutableListOf()

    fun add(process: Process) = processList.add(process.toExecutedProcess())

    fun add(process: ExecutedProcess) = processList.add(process)

    fun isEmpty() = processList.isEmpty()

    fun getShortestBurstTimeProcess(): ExecutedProcess {
        val process = processList.minByOrNull { it.remainingBurstTime.value }
        val index = processList.indexOf(process)
        processList.removeAt(index)
        return process!!
    }

    fun getAllProcessNameList() = processList.map { it.name }
}