package com.one0one.unitconverterapp1.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDao {
    @Insert
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("DELETE  FROM result_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM result_table")
    fun getResult(): Flow<List<ConversionResult>>
}