package com.one0one.unitconverterapp1.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.one0one.unitconverterapp1.data.ConverterViewModel

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        val list = converterViewModel.getConversion()
        TopScreen(list)
        Spacer(modifier = modifier.height(10.dp))
        HistoryScreen()
    }

}