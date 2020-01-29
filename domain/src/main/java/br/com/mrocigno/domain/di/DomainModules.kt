package br.com.mrocigno.domain.di

import br.com.mrocigno.domain.usecase.MainUseCase
import br.com.mrocigno.domain.usecase.MainUseCaseImpl
import org.koin.dsl.module

object DomainModules {

    val useCaseModule = module {
        single<MainUseCase> { MainUseCaseImpl(get()) }
    }

}