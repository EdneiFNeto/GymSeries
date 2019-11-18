package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Serie


@Dao
interface SeriesRoom {

    @Insert
    fun insert(serie: Serie)

    @Update
    fun update(serie: Serie)

    @Delete
    fun delete(serie: Serie)


    @Query("SELECT * FROM Serie s")
    fun all():List<Serie>
}