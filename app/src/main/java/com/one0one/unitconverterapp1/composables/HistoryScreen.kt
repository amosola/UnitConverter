package com.one0one.unitconverterapp1.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.one0one.unitconverterapp1.room.ConversionResult

@Composable
fun HistoryScreen(
    list : State<List<ConversionResult>>,
    onCloseTask : (ConversionResult) -> Unit,
    clear : () -> Unit,
    modifier: Modifier = Modifier
){
    Column() {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "History",
                color = Color.Gray
            )
            OutlinedButton(
                onClick = { clear() }
            ) {
                Text(text = "Clear all")
            }
        }
        HistoryList(
            list = list,
            onCloseTask = { item ->
                onCloseTask(item)
            }
        )
    }
}