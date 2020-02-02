package br.com.mrocigno.data.di

import androidx.room.Room
import br.com.mrocigno.data.datasource.GuideDataSource
import br.com.mrocigno.data.datasource.GuideDataSourceImpl
import br.com.mrocigno.data.datasource.PhotoDataSource
import br.com.mrocigno.data.datasource.PhotoDataSourceImpl
import br.com.mrocigno.data.db.AppDatabase
import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.data.mapper.GuideMapper
import br.com.mrocigno.data.mapper.PhotoMapper
import br.com.mrocigno.data.repository.GuideRepositoryImpl
import br.com.mrocigno.data.repository.PhotoRepositoryImpl
import br.com.mrocigno.domain.repository.GuideRepository
import br.com.mrocigno.domain.repository.PhotoRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModules {

    private const val GUIDE_DATA_SOURCE = "GuideDataSource"

    val databaseModules = module {
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "rdf-db").build()
        }

        single { (get() as AppDatabase).guidesDao() }
        single { (get() as AppDatabase).photosDao() }
    }

    val repositoryModule = module {
        single<GuideRepository> { GuideRepositoryImpl(get()) }
        single<PhotoRepository> { PhotoRepositoryImpl(get()) }
    }

    val dataSourceModule = module {
        single { GuideDataSourceImpl( get(), get(named(GUIDE_MAPPER_FROM_DATA))) }
        single<GuideDataSource.Local> { get() as GuideDataSourceImpl }

        single { PhotoDataSourceImpl( get(), get(named(PHOTO_MAPPER_FROM_DATA))) }
        single<PhotoDataSource.Local> { get() as PhotoDataSourceImpl }
    }

    private const val GUIDE_MAPPER_FROM_DATA = "GuideMapper.FromData"
    private const val PHOTO_MAPPER_FROM_DATA = "PhotoMapper.FromData"

    val mapperModule = module {
        single(named(GUIDE_MAPPER_FROM_DATA)) { GuideMapper.FromData() }
        single(named(PHOTO_MAPPER_FROM_DATA)) { PhotoMapper.FromData() }
    }

}