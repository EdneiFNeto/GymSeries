package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Peito

@Dao
interface PeitoRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(peito: Peito)

    @Delete
    fun delete(peito: Peito)

    @Update
    fun update(peito: Peito):Int

    @Query("SELECT * FROM Peito")
    fun all():List<Peito>

    @Query("SELECT * FROM peito WHERE status = :status ")
    fun allStates(status: Boolean):List<Peito>
}
