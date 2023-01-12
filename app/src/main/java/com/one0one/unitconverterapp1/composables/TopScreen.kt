package com.one0one.unitconverterapp1.composables

import android.util.Log
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.one0one.unitconverterapp1.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    save : (String, String) -> Unit
) {
    val selectedConversion : MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText : MutableState<String> = remember { mutableStateOf("")}
    val typedValue : MutableState<String> = remember { mutableStateOf("0.0") }

    ConverterMenu(list){
        selectedConversion.value = it
        typedValue.value = "0.0"
    }
    selectedConversion.value?.let {
        InputScreen(conversion = it, inputText = inputText){ input ->
            typedValue.value = input

        }
    }
    if (typedValue.value != "0.0"){
        val value = typedValue.value.toDouble()
        val multiplyBy = selectedConversion.value!!.multiplyBy
        val result = value*multiplyBy

        //Round down to four decimal places
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"

        save(message1,message2)
        ResultBlock(message1 = message1, message2 = message2)
    }
}