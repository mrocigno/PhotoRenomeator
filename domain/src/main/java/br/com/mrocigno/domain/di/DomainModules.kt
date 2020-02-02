package br.com.mrocigno.domain.di

import br.com.mrocigno.domain.usecase.*
import org.koin.dsl.module

object DomainModules {

    val useCaseModule = module {
        single<MainUseCase> { MainUseCaseImpl(get()) }
        single<GuideUseCase> { GuideUseCaseImpl(get()) }
        single<ServiceUseCase> { ServiceUseCaseImpl(get()) }
    }

}