package com.example.sudoku

import android.util.Log
import androidx.compose.runtime.Composable

var sudokuArray = mutableListOf(
    intArrayOf(0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0)
)

@Composable
fun sudokuLogic() {
    //Rows
    val pullRow1 = mutableListOf(1, 2, 3, 4)
    val pullRow2 = mutableListOf(1, 2, 3, 4)
    val pullRow3 = mutableListOf(1, 2, 3, 4)
    val pullRow4 = mutableListOf(1, 2, 3, 4)
    //Columns
    val pullRow5 = mutableListOf(1, 2, 3, 4)
    val pullRow6 = mutableListOf(1, 2, 3, 4)
    val pullRow7 = mutableListOf(1, 2, 3, 4)
    val pullRow8 = mutableListOf(1, 2, 3, 4)
    //Box
    val pullRow9 = mutableListOf(1, 2, 3, 4)
    val pullRow10 = mutableListOf(1, 2, 3, 4)
    val pullRow11 = mutableListOf(1, 2, 3, 4)
    val pullRow12 = mutableListOf(1, 2, 3, 4)

    val rows = arrayOf(pullRow1, pullRow2, pullRow3, pullRow4)
    val columns = arrayOf(pullRow5, pullRow6, pullRow7, pullRow8)
    val boxes = arrayOf(pullRow9, pullRow10, pullRow11, pullRow12)

    for (i in sudokuArray.indices) {
        for (j in sudokuArray[i].indices) {
            val index = (i * sudokuArray[i].size + j) % boxes.size
            val generatedRandomNumber = generateRandomNumber(rows[i], columns[j], boxes[index])
            removeNumber(generatedRandomNumber, rows[i], columns[j], boxes[index])
            sudokuArray[i][j] = generatedRandomNumber
        }
    }
    for (i in sudokuArray) {
        val rowString = i.joinToString(" ")
        Log.d("sudokuArr: ", rowString)
    }
}

fun generateRandomNumber(
    firstPullRow: MutableList<Int>,
    secondPullRow: MutableList<Int>,
    thirdPullRow: MutableList<Int>
): Int {
    Log.v("sudokulogic: ", "firstPullRow: $firstPullRow")
    Log.v("sudokulogic: ", "secondPullRow: $secondPullRow")

    Log.v("sudokulogic: ", "firstPullRow: " + firstPullRow.intersect(secondPullRow.toSet()))
    val availableGeneratedNumber = firstPullRow.intersect(secondPullRow.toSet())
        .intersect(thirdPullRow.toSet())

    return availableGeneratedNumber.random()
}

fun removeNumber(
    generatedNumber: Int,
    firstPullRow: MutableList<Int>,
    secondPullRow: MutableList<Int>,
    thirdPullRow: MutableList<Int>
) {
    Log.v("sudokulogic: ", generatedNumber.toString())
    Log.v("sudokulogic: ", firstPullRow.toString())
    Log.v("sudokulogic: ", secondPullRow.toString())
    Log.v("sudokulogic: ", thirdPullRow.toString())
    firstPullRow.remove(generatedNumber)
    secondPullRow.remove(generatedNumber)
    thirdPullRow.remove(generatedNumber)
}

