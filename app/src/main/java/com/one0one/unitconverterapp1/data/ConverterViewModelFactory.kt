package com.one0one.unitconverterapp1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.one0one.unitconverterapp1.room.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T
}