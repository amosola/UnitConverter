package com.one0one.unitconverterapp1.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.one0one.unitconverterapp1.data.Conversion

@Composable
fun InputScreen(
    conversion: Conversion,
    modifier: Modifier = Modifier,
    inputText : MutableState<String>
){
    Column(modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it},
                modifier = modifier.fillMaxWidth(0.65f),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                ),
                textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
                )

            Text(
                text = conversion.convertFrom,
                fontSize = 24.sp,
                modifier = modifier
                    .fillMaxWidth(0.35f)
                    .padding(10.dp, 30.dp, 0.dp, 0.dp)
            )
        }
        
        OutlinedButton(onClick = { /*TODO*/ }) {
            
        }

    }

}