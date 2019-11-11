package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.BicepsRoom
import com.gymseries.model.Biceps

@Database(
    entities = [Biceps::class],
    version = 1
)
abstract  class AppData : RoomDatabase() {

    abstract fun bicepsDao(): BicepsRoom

    companion object{
        fun getInstance(context: Context):AppData{
            return Room
                .databaseBuilder(context, AppData::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}