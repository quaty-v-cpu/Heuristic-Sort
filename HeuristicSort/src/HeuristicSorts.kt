package HeuristicSort

import kotlin.math.round

// mit der binären Suche
fun HeuristicSort_binarySearch(Arr : MutableList<Int>, ausgeben : Boolean) {
    val Minimum = Arr.minOrNull() ?: 0
    val Maximum = Arr.maxOrNull() ?: 0
    val MaxIndex = Arr.count() - 1
    var MinIndex = 0

    // Funktion : y = k * x + b

    val k : Double = (MaxIndex - MinIndex).toDouble() / (Maximum - Minimum).toDouble()
    val b : Double = MinIndex - k * Minimum

    val SortArr = MutableList(Arr.count()){0}

    // Sortieren mit der Ausrechnung von Indexes
    val RestArr = mutableListOf<Int>()
    for (i in 0 until Arr.count()) {
        val zielIndex = round(Arr[i] * k + b).toInt()
        if (SortArr[zielIndex] == 0) {
            SortArr[zielIndex] = Arr[i]
        } else {
            RestArr.add(Arr[i])
        }
    }

    // Erfolgsprozent ausrechnen
    val Prozent = 100 - (RestArr.count().toDouble() / Arr.count().toDouble()) * 100
    println("Erfolg mit $Prozent %")

    SortArr.removeAll {it == 0}

    // Die Restelemente reinsortieren
    for (el in RestArr) {
        // Position suchen mit binären Suche
        var Index = binarySearch(el, SortArr)
        if (Index == SortArr.count() - 1 && SortArr[Index] < el) {
            SortArr.add(el)
        } else {
            SortArr.add(Index, el)
        }
    }

    //if (!checkOutput(SortArr)) println("Problem mit HeuristicSort_binarySearch")
    if (ausgeben)  println(SortArr)
}

// mit der linearen Suche
fun HeuristicSort_linearSearch(Arr : MutableList<Int>, ausgeben : Boolean) {
    val Minimum = Arr.minOrNull() ?: 0
    val Maximum = Arr.maxOrNull() ?: 0
    val MaxIndex = Arr.count() - 1
    var MinIndex = 0

    val k : Double = (MaxIndex - MinIndex).toDouble() / (Maximum - Minimum).toDouble()
    val b : Double = MinIndex - k * Minimum

    val SortArr = MutableList(Arr.count()){0}

    // Sortieren mit der Ausrechnung von Indexes
    val RestArr = mutableListOf<Int>()
    for (i in 0 until Arr.count()) {
        val zielIndex = round(Arr[i] * k + b).toInt()
        if (SortArr[zielIndex] == 0) {
            SortArr[zielIndex] = Arr[i]
        } else {
            RestArr.add(Arr[i])
        }
    }

    // Erfolgsprozent ausrechnen
    val Prozent = 100 - (RestArr.count().toDouble() / Arr.count().toDouble()) * 100
    println("Erfolg mit $Prozent %")

    SortArr.removeAll {it == 0}

    // Die Restelemente reinsortieren
    for (el in RestArr) {
        var i = 0
        while (i < SortArr.count() && el > SortArr[i]) i++

        if (i == SortArr.count()) {
            SortArr.add(el)
        } else {
            SortArr.add(i, el)
        }

    }

    //if (!checkOutput(SortArr)) println("Problem mit HeuristicSort_linearSearch")
    if (ausgeben)  println(SortArr)
}
