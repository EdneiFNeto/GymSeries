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
        User::class,
        Peito::class,
        Ombro::class,
        Perna::class,
        IMC::class,
        Charts::class,
        Serie::class,
        Costa::class],

    version = 32,
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
    abstract fun imcRoom(): IMCRoom
    abstract fun chartsRoom(): ChartsRoom
    abstract fun userRoom(): UserRoom
    abstract fun serieRoom(): SerieRomm

    companion object {

        fun getInstance(context: Context?): AppData? {

            if(context!=null){
            return Room
                .databaseBuilder(context, AppData::class.java, "gym_db")
                .fallbackToDestructiveMigration()
                .build()
            }

            return null
        }
    }
}