package com.matthew.sudoku

import SudokuBox
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//    onAction: (SudokuAction) -> Unit
) {
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
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                    SudokuBox(modifier)
                }
            }
        }
    }
}

