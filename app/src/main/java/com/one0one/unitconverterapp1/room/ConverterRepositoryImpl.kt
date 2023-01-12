package com.one0one.unitconverterapp1.room

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao : ConverterDao) : ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getResult(): Flow<List<ConversionResult>> {
        return dao.getResult()
    }
}