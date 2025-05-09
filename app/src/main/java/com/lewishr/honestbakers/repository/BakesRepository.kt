package com.lewishr.honestbakers.repository

import android.content.Context
import com.lewishr.honestbakers.data.BakesDatabase
import com.lewishr.honestbakers.model.Bakes


class BakesRepository(context: Context) {
    private val bakesDao = BakesDatabase.getDatabase(context).bakesDao()

    suspend fun insertBakes(bakes: Bakes) {
        bakesDao.insertBakes(bakes)
    }

    fun getAllBakes() = bakesDao.getAllBakes()

    suspend fun deleteBakes(bakes: Bakes) = bakesDao.deleteBakes(bakes)
}