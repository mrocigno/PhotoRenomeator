package br.com.mrocigno.infrastructure.base

import androidx.lifecycle.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

abstract class AbstractViewModel : ViewModel(), LifecycleObserver, KoinComponent {

    val loading: LiveData<Boolean> get() = _loading
    private val _loading = MutableLiveData<Boolean>()

    protected fun launchDataLoad(
        checkConnection: Boolean = false,
        block: suspend () -> Unit,
        doOnError: (error: Exception) -> Unit = {}
    ): Job {
        return  viewModelScope.launch {
//            if ((checkConnection && network.hasActiveInternetConnection()) || !checkConnection) {
                try {
                    _loading.value = true
                    block()
                } catch (error: Exception) {
                    doOnError(error)
                } finally {
                    _loading.value = false
                }
//            } else _noConnectionError.value = resourcesStringError.noConnectionError
        }
    }

}