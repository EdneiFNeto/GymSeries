package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.OmbroTestRoom
import com.gymseries.model.Ombro

@Database(entities = [Ombro::class], exportSchema = false, version = 1)
abstract class DataBaseGeneric : RoomDatabase() {

    abstract fun getOmbroRoom(): OmbroTestRoom

    companion object{
        fun getInstance(context: Context): DataBaseGeneric {
            return Room
                .databaseBuilder(context, DataBaseGeneric::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}