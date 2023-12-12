package com.matthew.sudoku

import SudokuBox
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudoku.sudokuArray
import com.example.sudoku.sudokuLogic
import com.example.sudoku.ui.theme.LightBlue
import com.example.sudoku.ui.theme.LightGreen
import com.example.sudoku.ui.theme.LightPink
import com.example.sudoku.ui.theme.LightRed
import kotlin.random.Random


@Composable
fun Sudoku(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    sudokuLogic()
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SUDOKU",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.size(40.dp))
            Column(verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier, name = sudokuArray[0][0])
                    SudokuBox(modifier, name = sudokuArray[0][1])
                    SudokuBox(modifier, name = sudokuArray[0][2])
                    SudokuBox(modifier, name = sudokuArray[0][3])
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier, name = sudokuArray[1][0])
                    SudokuBox(modifier, name = sudokuArray[1][1])
                    SudokuBox(modifier, name = sudokuArray[1][2])
                    SudokuBox(modifier, name = sudokuArray[1][3])
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier, name = sudokuArray[2][0])
                    SudokuBox(modifier, name = sudokuArray[2][1])
                    SudokuBox(modifier, name = sudokuArray[2][2])
                    SudokuBox(modifier, name = sudokuArray[2][3])
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier, name = sudokuArray[3][0])
                    SudokuBox(modifier, name = sudokuArray[3][1])
                    SudokuBox(modifier, name = sudokuArray[3][2])
                    SudokuBox(modifier, name = sudokuArray[3][3])
                }
            }
            Button(onClick = { isVisible = !isVisible }) {
                Text("Jawaban")
            }
            Box(
                modifier = Modifier
                    .then(modifier)
                    .size(250.dp)
                    .border(color = Color.Black, width = 2.dp), contentAlignment = Alignment.Center
            ) {
                if (isVisible) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(40.dp), verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (i in sudokuArray.indices) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                for (j in sudokuArray[i].indices) {
                                    Text(
                                        sudokuArray[i][j].toString(),
                                        textAlign = TextAlign.Center,
                                        fontSize = 25.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

