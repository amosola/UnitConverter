package com.one0one.unitconverterapp1.room

import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAll()
    fun getResult(): Flow<List<ConversionResult>>
}