//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package HeuristicSort

import kotlin.math.round
import kotlin.math.abs
import kotlin.time.measureTime



fun main() {
    val Arr = (1..30000).map {(1..200000).random()}.toMutableList()

    val duration1 = measureTime {
        InsertSort(Arr, false)
    }

    println("InsertSort läuft in ${duration1.inWholeMicroseconds} microseconds")

    val duration2 = measureTime {
        HeuristicSort_binarySearch(Arr, false)
    }

    println("HeuristicSort läuft in ${duration2.inWholeMicroseconds} microseconds")

    println("HeuristicSort ist schneller als InsertSort in ${duration1.inWholeMicroseconds.toDouble() / duration2.inWholeMicroseconds.toDouble()} Mal")

}