package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.Peito

@Dao
abstract class PeitoRoom :BaseRoom<Peito>
