package br.com.mrocigno.renomeadordefoto.di

import br.com.mrocigno.renomeadordefoto.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModules {

    val viewModels = module {
        viewModel { MainViewModel() }
    }

}