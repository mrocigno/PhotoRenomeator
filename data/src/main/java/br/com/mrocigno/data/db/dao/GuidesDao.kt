package br.com.mrocigno.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mrocigno.domain.entity.Guide

@Dao
interface GuidesDao {

    @Query("SELECT * FROM guides")
    fun listAll() : List<Guide>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(guide: Guide)

}