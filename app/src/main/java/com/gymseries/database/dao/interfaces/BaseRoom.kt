package com.gymseries.database.dao.interfaces

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.gymseries.model.Ombro

@Dao
interface BaseRoom<T> {

    @Insert
    fun insert(t: T):Long

    @Delete
    fun delete(t: T)

    @Update
    fun update(t: T)

    @RawQuery
    fun all(query: SupportSQLiteQuery ): List<T>
}
