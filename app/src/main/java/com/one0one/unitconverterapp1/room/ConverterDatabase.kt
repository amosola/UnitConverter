package com.one0one.unitconverterapp1.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConversionResult :: class], version = 1)
abstract class ConverterDatabase : RoomDatabase() {
    abstract fun converterDao(): ConverterDao

    companion object{
        @Volatile
        private var INSTANCE : ConverterDatabase? =null
        fun getDatabase(context: Context): ConverterDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ConverterDatabase::class.java,
                    "converter_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}