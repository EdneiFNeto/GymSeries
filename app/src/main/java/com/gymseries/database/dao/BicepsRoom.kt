package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Biceps

@Dao
interface BicepsRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(biceps: Biceps)

    @Query("DELETE FROM Biceps")
    fun delete()

    @Update
    fun update(biceps: Biceps):Int

    @Query("SELECT * FROM biceps b")
    fun all():List<Biceps>
}