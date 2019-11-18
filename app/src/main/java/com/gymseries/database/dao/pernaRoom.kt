package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Ombro
import com.gymseries.model.Perna

@Dao
interface pernaRoom {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(perna: Perna)

    @Delete
    fun delete(perna: Perna)

    @Update
    fun update(perna: Perna):Int

    @Query("SELECT * FROM Perna")
    fun all():List<Perna>

    @Query("SELECT * FROM perna WHERE status = :status ")
    fun allStates(status: Boolean):List<Perna>

}
