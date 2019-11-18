package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.BicepsRoom
import com.gymseries.database.dao.GenericDao
import com.gymseries.database.dao.SeriesRoom
import com.gymseries.database.dao.TricepsRoom
import com.gymseries.model.Biceps
import com.gymseries.model.Serie
import com.gymseries.model.Triceps

@Database(
    entities = [Biceps::class, Triceps::class, Serie::class],
    version = 4,
    exportSchema = false
)
abstract  class AppData : RoomDatabase() {

    abstract fun bicepsRoom(): BicepsRoom
    abstract fun tricepsDao(): TricepsRoom
    abstract fun seriesDao(): SeriesRoom

    companion object{
        fun getInstance(context: Context):AppData{
            return Room
                .databaseBuilder(context, AppData::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}