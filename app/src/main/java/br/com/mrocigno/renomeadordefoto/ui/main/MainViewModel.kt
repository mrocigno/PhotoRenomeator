package br.com.mrocigno.renomeadordefoto.ui.main

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.domain.usecase.MainUseCase
import br.com.mrocigno.infrastructure.base.AbstractViewModel

class MainViewModel(
    private val mainUseCase: MainUseCase
) : AbstractViewModel() {

    private val _list = MutableLiveData<List<GuideList>>()
    val list: LiveData<List<GuideList>> = _list

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun listGuides(){
        launchDataLoad(
            block = {
                _list.value = mainUseCase.listGuidesName()
//                Log.d("DEBUG TEST", "${mainUseCase.listGuidesName()}")
            },
            doOnError = {
                Log.e("DEBUG TEST", "", it)
            }
        )
    }

}