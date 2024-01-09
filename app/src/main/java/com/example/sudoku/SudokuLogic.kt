package com.example.sudoku

import android.app.AlertDialog
import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.random.Random

var sudokuArray = mutableListOf(
    intArrayOf(0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0)
)

var sudokuShowAnswer: MutableList<IntArray> = mutableListOf()
var sudokuStoreAnswer: MutableList<Int> = mutableListOf()
var sudokuCompareAnswerV2 = mutableMapOf<String, Int>()
var isGameReset = false
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
            //Extras
            val extraValidation = mutableListOf(1, 2, 3, 4)

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

            if (i == 2 && j == 1) {
                //##1.Logic Filter dua angka sama
                if (sudokuArray[2][0] == sudokuArray[0][2]) {
                    extraValidation.remove(sudokuArray[1][2])
                } else if (sudokuArray[2][0] == sudokuArray[1][2]) {
                    extraValidation.remove(sudokuArray[0][2])
                }

                //##2. Logic Filter angka berurutan
                else {
                    val filterArray = mutableListOf(1, 2, 3, 4)

                    filterArray.remove(sudokuArray[0][2])
                    filterArray.remove(sudokuArray[1][2])
                    filterArray.remove(sudokuArray[2][0])

                    if (filterArray.size > 0) {
                        extraValidation.remove(filterArray[0])
                    }
                }
            }
            val generatedRandomNumber =
                generateRandomNumber(rows[i], columns[j], boxes[index], extraValidation)
            removeNumberFromPullRow(generatedRandomNumber, rows[i], columns[j], boxes[index])
            sudokuArray[i][j] = generatedRandomNumber
        }
    }
    sudokuShowAnswer = sudokuArray.map { it.copyOf() }.toTypedArray().toMutableList()
    for (i in sudokuShowAnswer.indices) {
        for (j in sudokuShowAnswer.indices) {
            Log.d("MAT", "SudokuAnswer: ${sudokuShowAnswer[i][j]}")
        }
    }
    removeNumber(sudokuArray)
    for (i in sudokuShowAnswer.indices) {
        for (j in sudokuShowAnswer.indices) {
            Log.d("MAT", "SudokuAnswer2: ${sudokuShowAnswer[i][j]}")
        }
    }
}

fun generateRandomNumber(
    firstPullRow: MutableList<Int>,
    secondPullRow: MutableList<Int>,
    thirdPullRow: MutableList<Int>,
    extraValidation: MutableList<Int>
): Int {
    Log.v("sudokulogic: ", "firstPullRow: $firstPullRow")
    Log.v("sudokulogic: ", "secondPullRow: $secondPullRow")
    Log.v("sudokulogic: ", "thirdPullRow: $thirdPullRow")

    val availableGeneratedNumber = firstPullRow.intersect(secondPullRow.toSet())
        .intersect(thirdPullRow.toSet()).intersect(extraValidation.toSet())
    Log.v("sudokulogic: ", "intersectedRow: $availableGeneratedNumber")
    return availableGeneratedNumber.random()
}

fun removeNumberFromPullRow(
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

fun removeNumber(sudokuArray: MutableList<IntArray>) {
    var count = 8
    for (i in sudokuArray.indices) {
        for (j in sudokuArray.indices) {
            val randomFlag = removeRandomizer()
            if (randomFlag) {
                sudokuStoreAnswer.add(sudokuArray[i][j])
                sudokuArray[i][j] = 0
                count -= 1
            }
        }
    }
}

fun removeRandomizer(): Boolean {
    return Random.nextBoolean()
}

fun verifyAnswers(): Boolean {
    val flatArray = sudokuCompareAnswerV2.values.toMutableList()
    flatArray.removeAll { it == 0 }
    return flatArray.sorted() == sudokuStoreAnswer.sorted()
}

fun resetGame() {
    sudokuArray = mutableListOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    sudokuShowAnswer = mutableListOf();
    sudokuStoreAnswer = mutableListOf()
    sudokuCompareAnswerV2 = mutableMapOf()

    isGameReset = true
}