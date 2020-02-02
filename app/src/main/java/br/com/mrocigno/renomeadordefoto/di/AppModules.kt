package br.com.mrocigno.renomeadordefoto.di

import br.com.mrocigno.renomeadordefoto.ui.guide.GuideViewModel
import br.com.mrocigno.renomeadordefoto.ui.main.MainViewModel
import br.com.mrocigno.renomeadordefoto.ui.service.ServiceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModules {

    val viewModels = module {
        viewModel { MainViewModel(get()) }
        viewModel { GuideViewModel(get()) }
        viewModel { ServiceViewModel() }
    }

}