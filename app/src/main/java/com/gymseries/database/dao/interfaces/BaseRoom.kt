package com.gymseries.database.dao.interfaces

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
abstract class BaseRoom<T> {

    @Insert
    fun insert(t: T){}

    @Delete
    fun delete(t: T){}

    @Update
    fun update(t: T){}

    @RawQuery
    fun <T>all(query: SupportSQLiteQuery): List<T>{return arrayListOf()}
}
