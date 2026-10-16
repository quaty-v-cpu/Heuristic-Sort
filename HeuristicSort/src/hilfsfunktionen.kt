package HeuristicSort

fun binarySearch(El : Int, Arr : MutableList<Int>) : Int {
    var start : Int = 0
    var end : Int = Arr.count() - 1

    do {
        var mitte : Int = start + (end - start) / 2
        if (Arr[mitte] >= El) end = mitte - 1
        if (Arr[mitte] < El) start = mitte + 1
    } while (start <= end)

    return start
}



fun checkOutput(Arr : MutableList<Int>) : Boolean {
    for (i in 1 until Arr.count()) {
        if (Arr[i] < Arr[i - 1]) return false
    }

    return true
}

fun InsertSort(Arr : MutableList<Int>, ausgeben : Boolean) {
    val TempArr = Arr.toMutableList()

    for (i in 1 until TempArr.count()) {
        var j = i
        while (j > 0 && TempArr[j] < TempArr[j - 1]) {
            var temp = TempArr[j]
            TempArr[j] = TempArr[j - 1]
            TempArr[j - 1] = temp
            j--
        }

    }

    //if (!checkOutput(TempArr)) println("Problem mit InstertSort")
    if (ausgeben) println(TempArr)
}
