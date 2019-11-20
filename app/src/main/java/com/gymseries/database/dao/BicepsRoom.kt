package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.Biceps

@Dao
abstract class BicepsRoom:BaseRoom<Biceps>