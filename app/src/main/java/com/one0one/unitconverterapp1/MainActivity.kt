package com.one0one.unitconverterapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.one0one.unitconverterapp1.composables.BaseScreen
import com.one0one.unitconverterapp1.data.ConverterViewModelFactory
import com.one0one.unitconverterapp1.room.ConverterDatabase
import com.one0one.unitconverterapp1.room.ConverterRepositoryImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ConverterDatabase.getDatabase(application).converterDao()
        val repositoryImpl = ConverterRepositoryImpl(dao)
        val factory = ConverterViewModelFactory(repositoryImpl)
        setContent {
           BaseScreen(factory = factory)
        }
    }
}