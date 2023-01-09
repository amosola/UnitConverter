package com.one0one.unitconverterapp1.composables

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.one0one.unitconverterapp1.data.Conversion

@Composable
fun TopScreen(list: List<Conversion>) {
    var selectedConversion : MutableState<Conversion?> = remember { mutableStateOf(null) }
    var inputText : MutableState<String> = remember { mutableStateOf("")}

    ConverterMenu(list){
        selectedConversion.value = it
    }
    selectedConversion.value?.let {
        InputScreen(
            conversion = it,
            inputText = inputText
        )
    }
}