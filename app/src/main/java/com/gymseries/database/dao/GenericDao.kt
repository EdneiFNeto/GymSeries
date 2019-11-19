package com.gymseries.database.dao

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface GenericDao<T> {

    @Insert
    fun insert(t: T)

    @Delete
    fun delete(t: T)

    @Update
    fun update(t: T)

    @RawQuery
    fun <T> all(query: SupportSQLiteQuery): List<T>

}
