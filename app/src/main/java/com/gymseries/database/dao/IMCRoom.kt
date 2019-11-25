package com.gymseries.database.dao

import androidx.room.Dao
import com.gymseries.database.dao.interfaces.BaseRoom
import com.gymseries.model.IMC

@Dao
abstract  class IMCRoom: BaseRoom<IMC> {}
