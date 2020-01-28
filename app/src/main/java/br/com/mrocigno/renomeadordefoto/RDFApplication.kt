package br.com.mrocigno.renomeadordefoto

import android.app.Application
import br.com.mrocigno.renomeadordefoto.di.AppComponent
import br.com.mrocigno.renomeadordefoto.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RDFApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RDFApplication)
            androidLogger()
            modules(AppComponent.getAllModules())
        }
    }

}