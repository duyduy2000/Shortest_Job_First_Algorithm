package domain.util

import domain.model.Process
import domain.util.MilliSeconds.Companion.ms

val fakeProcessList1 by lazy {
    listOf(
        Process(
            name = "P1",
            arrivalTime = 2.ms,
            burstTime = 6.ms
        ),
        Process(
            name = "P2",
            arrivalTime = 5.ms,
            burstTime = 2.ms
        ),
        Process(
            name = "P3",
            arrivalTime = 1.ms,
            burstTime = 8.ms
        ),
        Process(
            name = "P4",
            arrivalTime = 0.ms,
            burstTime = 3.ms
        ),
        Process(
            name = "P5",
            arrivalTime = 4.ms,
            burstTime = 4.ms
        )
    )
}

val fakeProcessList2 by lazy {
    listOf(
        Process(
            name = "P1",
            arrivalTime = 0.ms,
            burstTime = 7.ms
        ),
        Process(
            name = "P2",
            arrivalTime = 2.ms,
            burstTime = 4.ms
        ),
        Process(
            name = "P3",
            arrivalTime = 4.ms,
            burstTime = 1.ms
        ),
        Process(
            name = "P4",
            arrivalTime = 5.ms,
            burstTime = 4.ms
        )
    )
}