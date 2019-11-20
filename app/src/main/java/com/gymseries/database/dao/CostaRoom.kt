package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.Biceps
import com.gymseries.model.Costa

@Dao
abstract class CostaRoom:BaseRoom<Costa>