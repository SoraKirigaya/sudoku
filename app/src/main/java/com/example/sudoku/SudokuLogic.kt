package com.example.sudoku

import android.util.Log
import androidx.compose.runtime.Composable

@Composable
fun sudokuLogic() {
    var sudokuArray = mutableListOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )
    //Rows
    var pullRow1 = mutableListOf(1, 2, 3, 4)
    var pullRow2 = mutableListOf(1, 2, 3, 4)
    var pullRow3 = mutableListOf(1, 2, 3, 4)
    var pullRow4 = mutableListOf(1, 2, 3, 4)
    //Columns
    var pullRow5 = mutableListOf(1, 2, 3, 4)
    var pullRow6 = mutableListOf(1, 2, 3, 4)
    var pullRow7 = mutableListOf(1, 2, 3, 4)
    var pullRow8 = mutableListOf(1, 2, 3, 4)
    //Box
    var pullRow9 = mutableListOf(1, 2, 3, 4)
    var pullRow10 = mutableListOf(1, 2, 3, 4)
    var pullRow11 = mutableListOf(1, 2, 3, 4)
    var pullRow12 = mutableListOf(1, 2, 3, 4)

    for (i in sudokuArray.indices) {
        for (j in sudokuArray[i].indices) {
            if (i == 0 && j == 0) {
                sudokuArray[i][j] = generateRandomNumber(pullRow1, pullRow5, pullRow9)
            } else if (i == 0 && j == 1) {
                sudokuArray[i][j] = generateRandomNumber(pullRow1, pullRow6, pullRow9)
            } else if (i == 0 && j == 2) {
                sudokuArray[i][j] = generateRandomNumber(pullRow1, pullRow7, pullRow10)
            } else if (i == 0 && j == 3) {
                sudokuArray[i][j] = generateRandomNumber(pullRow1, pullRow8, pullRow10)
            } else if (i == 1 && j == 0) {
                sudokuArray[i][j] = generateRandomNumber(pullRow2, pullRow5, pullRow9)
            } else if (i == 1 && j == 1) {
                sudokuArray[i][j] = generateRandomNumber(pullRow2, pullRow6, pullRow9)
            } else if (i == 1 && j == 2) {
                sudokuArray[i][j] = generateRandomNumber(pullRow2, pullRow7, pullRow10)
            } else if (i == 1 && j == 3) {
                sudokuArray[i][j] = generateRandomNumber(pullRow2, pullRow8, pullRow10)
            } else if (i == 2 && j == 0) {
                sudokuArray[i][j] = generateRandomNumber(pullRow3, pullRow5, pullRow11)
            } else if (i == 2 && j == 1) {
                sudokuArray[i][j] = generateRandomNumber(pullRow3, pullRow6, pullRow11)
            } else if (i == 2 && j == 2) {
                sudokuArray[i][j] = generateRandomNumber(pullRow3, pullRow7, pullRow12)
            } else if (i == 2 && j == 3) {
                sudokuArray[i][j] = generateRandomNumber(pullRow3, pullRow8, pullRow12)
            } else if (i == 3 && j == 0) {
                sudokuArray[i][j] = generateRandomNumber(pullRow4, pullRow5, pullRow11)
            } else if (i == 3 && j == 1) {
                sudokuArray[i][j] = generateRandomNumber(pullRow4, pullRow6, pullRow11)
            } else if (i == 3 && j == 2) {
                sudokuArray[i][j] = generateRandomNumber(pullRow4, pullRow7, pullRow12)
            } else if (i == 3 && j == 3) {
                sudokuArray[i][j] = generateRandomNumber(pullRow4, pullRow8, pullRow12)
            }
        }
    }
    for (i in sudokuArray) {
        val rowString = i.joinToString (" ")
        Log.d("sudokuArr: ", rowString)
    }
}

fun generateRandomNumber(
    firstPullRow: MutableList<Int>,
    secondPullRow: MutableList<Int>,
    thirdPullRow: MutableList<Int>
): Int {
    var availableGeneratedNumber = mutableListOf<Int>()
    for (i in firstPullRow.indices) {
        for (j in secondPullRow.indices) {
            for (k in thirdPullRow.indices) {
                if (firstPullRow[i] == secondPullRow[j] && secondPullRow[j] == thirdPullRow[k]) {
                    availableGeneratedNumber.add(firstPullRow[i])
                    Log.d("available number: ", availableGeneratedNumber.toString())
                }
            }
        }
    }
    var generatedNumber = availableGeneratedNumber.random()
    Log.d("generatedNumber: ", generatedNumber.toString())
    firstPullRow.remove(generatedNumber)
    Log.d("firstPullRow: ", firstPullRow.toString())
    secondPullRow.remove(generatedNumber)
    Log.d("secondPullRow: ", secondPullRow.toString())
    thirdPullRow.remove(generatedNumber)
    Log.d("thirdPullRow: ", thirdPullRow.toString())
    return generatedNumber
}