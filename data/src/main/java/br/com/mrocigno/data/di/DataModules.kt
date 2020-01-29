package br.com.mrocigno.data.di

import androidx.room.Room
import br.com.mrocigno.data.datasource.GuideDataSource
import br.com.mrocigno.data.datasource.GuideDataSourceImpl
import br.com.mrocigno.data.db.AppDatabase
import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.data.repository.GuideRepositoryImpl
import br.com.mrocigno.domain.repository.GuideRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModules {

    private const val GUIDE_DATA_SOURCE = "GuideDataSource"

    val databaseModules = module {
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "rdf-db").build()
        }

        single {
            (get() as AppDatabase).guidesDao()
        }
    }

    val repositoryModule = module {
        single<GuideRepository> { GuideRepositoryImpl(get()) }
    }

    val datasourceModule = module {
        single(named(GUIDE_DATA_SOURCE)) { GuideDataSourceImpl(get()) }
        single<GuideDataSource.Local> { get(named(GUIDE_DATA_SOURCE)) }
    }

}