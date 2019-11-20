package com.gymseries.database.dao

import androidx.room.*
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.Ombro
import com.gymseries.model.Perna

@Dao
abstract class pernaRoom :BaseRoom<Perna>
