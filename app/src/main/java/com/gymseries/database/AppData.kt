package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.*
import com.gymseries.model.*

@Database(
    entities = [Biceps::class,
        Triceps::class,
        Peito::class,
        Ombro::class,
        Perna::class,
        Costa::class],

    version = 6,
    exportSchema = false
)
abstract class AppData : RoomDatabase() {

    abstract fun bicepsRoom(): BicepsRoom
    abstract fun tricepsDao(): TricepsRoom
    abstract fun peitoDao(): PeitoRoom
    abstract fun ombroDao(): OmbroRoom
    abstract fun pernaDao(): pernaRoom
    abstract fun costaDao(): CostaRoom

    companion object {
        fun getInstance(context: Context): AppData {
            return Room
                .databaseBuilder(context, AppData::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}