package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.BicepsRoom
import com.gymseries.database.dao.GenericDao
import com.gymseries.database.dao.TricepsRoom
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps

@Database(
    entities = [Biceps::class, Triceps::class],
    version = 2,
    exportSchema = false
)
abstract  class AppData : RoomDatabase() {

    abstract fun bicepsRoom(): BicepsRoom
    abstract fun tricepsDao(): TricepsRoom

    companion object{
        fun getInstance(context: Context):AppData{
            return Room
                .databaseBuilder(context, AppData::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}