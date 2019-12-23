package com.gymseries.database.dao

import androidx.room.Dao
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.User

@Dao
abstract class UserRoom : BaseRoom<User>


