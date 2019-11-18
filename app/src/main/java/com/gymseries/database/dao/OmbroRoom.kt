package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Ombro

@Dao
interface OmbroRoom {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ombro: Ombro)

    @Delete
    fun delete(ombro: Ombro)

    @Update
    fun update(ombro: Ombro):Int

    @Query("SELECT * FROM ombro")
    fun all():List<Ombro>

    @Query("SELECT * FROM ombro WHERE status = :status ")
    fun allStates(status: Boolean):List<Ombro>

}
