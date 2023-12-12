package com.example.sudoku

import android.util.Log
import androidx.compose.runtime.Composable
import java.lang.Exception

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
            var index = 0
            if (i <= 1 && j <= 1) {
                index = 0
            } else if (i <= 1 && j >= 2) {
                index = 1
            } else if (i >= 2 && j <= 1) {
                index = 2
            } else if (i >= 2 && j >= 2) {
                index = 3
            }
//            val index = (i * sudokuArray[i].size + j) % boxes.size
            val generatedRandomNumber = generateRandomNumber(rows[i], columns[j], boxes[index])
            removeNumber(generatedRandomNumber, rows[i], columns[j], boxes[index])
            sudokuArray[i][j] = generatedRandomNumber
        }
    }
}

fun generateRandomNumber(
    firstPullRow: MutableList<Int>,
    secondPullRow: MutableList<Int>,
    thirdPullRow: MutableList<Int>
): Int {
    Log.v("sudokulogic: ", "firstPullRow: $firstPullRow")
    Log.v("sudokulogic: ", "secondPullRow: $secondPullRow")
    Log.v("sudokulogic: ", "thirdPullRow: $thirdPullRow")

    val availableGeneratedNumber = firstPullRow.intersect(secondPullRow.toSet())
        .intersect(thirdPullRow.toSet())
    Log.v("sudokulogic: ", "intersectedRow: $availableGeneratedNumber")
    return availableGeneratedNumber.random()
}

fun removeNumber(
    generatedNumber: Int,
    firstPullRow: MutableList<Int>,
    secondPullRow: MutableList<Int>,
    thirdPullRow: MutableList<Int>
) {
    Log.v("sudokulogic: ", "generatedNumber: $generatedNumber")
    firstPullRow.remove(generatedNumber)
    secondPullRow.remove(generatedNumber)
    thirdPullRow.remove(generatedNumber)
}

