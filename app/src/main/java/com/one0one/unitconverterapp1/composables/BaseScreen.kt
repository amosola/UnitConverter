package com.one0one.unitconverterapp1.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.one0one.unitconverterapp1.data.ConverterViewModel
import com.one0one.unitconverterapp1.data.ConverterViewModelFactory

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        val list = converterViewModel.getConversion()
        val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())
        TopScreen(list){message1, message2 ->
            converterViewModel.addResult(message1, message2)
        }
        Spacer(modifier = modifier.height(10.dp))

        HistoryScreen(
            historyList, { item ->
                converterViewModel.removeResult(item)
            },
            {
             converterViewModel.clearAll()
            }
        )
    }

}