package com.gymseries.database.dao.interfaces

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.gymseries.model.Ombro

@Dao
interface BaseRoom<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T):Long

    @Delete
    fun delete(t: T):Int

    @Update
    fun update(t: T):Int

    @RawQuery
    fun all(query: SupportSQLiteQuery ): List<T>
}
