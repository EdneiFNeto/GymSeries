package com.gymseries.database

import android.content.Context
import androidx.room.Dao
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

    version = 7,
    exportSchema = false
)
abstract class AppData : RoomDatabase() {

    abstract fun peitoRoom(): PeitoRoom
    abstract fun ombroRoom(): OmbroRoom
    abstract fun pernaRoom(): pernaRoom
    abstract fun costaRoom(): CostaRoom


    abstract fun tricepsRoom(): TricepsRoom
    abstract fun bicepsRoom(): BicepsRoom
    abstract fun getOmbroRoom(): OmbroTestRoom

    companion object {
        fun getInstance(context: Context): AppData {
            return Room
                .databaseBuilder(context, AppData::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}