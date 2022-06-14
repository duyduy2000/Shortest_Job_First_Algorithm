package domain.util

data class MilliSeconds(var value: Int) {

    operator fun compareTo(other: MilliSeconds): Int {
        when {
            this.value == other.value -> return 0
            this.value > other.value -> return 1
        }
        return -1
    }

    operator fun plusAssign(other: Int) {
        value += other
    }

    operator fun plusAssign(other: MilliSeconds) {
        value += other.value
    }

    operator fun minus(other: MilliSeconds): MilliSeconds = (value - other.value).ms

    operator fun minusAssign(other: MilliSeconds) {
        value -= other.value
    }

    operator fun inc(): MilliSeconds = MilliSeconds(++value)


    companion object {
        inline val Int.ms: MilliSeconds get() = MilliSeconds(value = this)
    }

}
