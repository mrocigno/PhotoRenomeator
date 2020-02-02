package br.com.mrocigno.renomeadordefoto.di

import br.com.mrocigno.data.di.DataModules
import br.com.mrocigno.domain.di.DomainModules
import org.koin.core.module.Module

object AppComponent {

    fun getAllModules() : List<Module> {
        return listOf(
            AppModules.viewModels,

            DataModules.databaseModules,
            DataModules.dataSourceModule,
            DataModules.repositoryModule,
            DataModules.mapperModule,

            DomainModules.useCaseModule
        )
    }

}