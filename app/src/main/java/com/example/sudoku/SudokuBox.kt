import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudoku.isGameReset
import com.example.sudoku.sudokuCompareAnswerV2
import java.lang.Exception

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SudokuBox(modifier: Modifier, name: Int, key: Int) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    val maxChar = 1

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .then(modifier)
            .size(56.dp)
            .border(color = Color.Black, width = 2.dp)
    ) {

        if (name == 0) {
            TextField(
                value = textFieldState,
                onValueChange = {
                    if (it.length <= maxChar) {
                        textFieldState = it
                        if (it.isNotEmpty()) {
                            sudokuCompareAnswerV2[key.toString()] = it.toInt()
                        } else {
                            textFieldState = it
                            sudokuCompareAnswerV2[key.toString()] = 0
                        }
                    }
                    Log.d("MAT", sudokuCompareAnswerV2.toString())
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            )
        } else {
            Text(
                name.toString(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }

    }
}