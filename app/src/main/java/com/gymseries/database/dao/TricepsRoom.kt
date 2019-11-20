package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps


@Dao
abstract  class TricepsRoom:BaseRoom<Triceps>