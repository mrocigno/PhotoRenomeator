package br.com.mrocigno.renomeadordefoto.di

import br.com.mrocigno.data.di.DataModules
import org.koin.core.module.Module

object AppComponent {

    fun getAllModules() : List<Module> {
        return listOf(
            AppModules.viewModels,

            DataModules.databaseModules
        )
    }

}