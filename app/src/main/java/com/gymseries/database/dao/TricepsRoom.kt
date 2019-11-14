package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps


@Dao
interface TricepsRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(triceps: Triceps)

    @Query("DELETE FROM Triceps")
    fun delete()

    @Update
    fun update(triceps: Triceps)

    @Query("SELECT * FROM triceps")
    fun all():List<Triceps>
}