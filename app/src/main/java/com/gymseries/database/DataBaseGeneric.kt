package com.gymseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gymseries.database.dao.GenericDao
import com.gymseries.database.dao.TricepsRoom
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps

@Database(
    entities = [Biceps::class, Triceps::class],
    version = 1,
    exportSchema = false
)
abstract class DataBaseGeneric : RoomDatabase() {
    companion object{}
}