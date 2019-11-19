package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.GenericDao
import com.gymseries.database.dao.OmbroRoom
import com.gymseries.database.dao.TricepsRoom
import com.gymseries.model.Biceps
import com.gymseries.model.Ombro
import com.gymseries.model.Triceps

@Database(entities = [Ombro::class], exportSchema = false, version = 1)
abstract class DataBaseGeneric : RoomDatabase() {

    abstract fun getOmbroRoom(): OmbroRoom
    companion object{
        fun getInstance(context: Context): DataBaseGeneric {
            return Room
                .databaseBuilder(context, DataBaseGeneric::class.java, "gym_db_genreric")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}