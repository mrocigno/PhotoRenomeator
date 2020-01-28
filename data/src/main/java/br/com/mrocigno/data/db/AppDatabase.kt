package br.com.mrocigno.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.domain.entity.Guide

@Database(entities = [
    Guide::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun guidesDao() : GuidesDao

}