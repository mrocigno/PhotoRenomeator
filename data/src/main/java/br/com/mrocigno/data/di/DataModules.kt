package br.com.mrocigno.data.di

import androidx.room.Room
import br.com.mrocigno.data.db.AppDatabase
import br.com.mrocigno.data.db.dao.GuidesDao
import org.koin.dsl.module

object DataModules {

    val databaseModules = module {
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "rdf-db").build()
        }

        single {
            (get() as AppDatabase).guidesDao()
        }
    }

}