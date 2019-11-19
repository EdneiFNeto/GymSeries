package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.model.Biceps
import com.gymseries.model.Costa

@Dao
interface CostaRoom {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(costa: Costa)

    @Query("DELETE FROM Costa")
    fun delete()

    @Update
    fun update(costa: Costa):Int

    @Query("SELECT * FROM costa")
    fun all():List<Costa>
}