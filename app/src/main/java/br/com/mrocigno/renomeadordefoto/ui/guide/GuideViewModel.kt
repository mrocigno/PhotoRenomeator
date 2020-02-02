package br.com.mrocigno.renomeadordefoto.ui.guide

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.usecase.GuideUseCase
import br.com.mrocigno.infrastructure.base.AbstractViewModel

class GuideViewModel(
    private val guideUseCase: GuideUseCase
) : AbstractViewModel() {

    private val _list = MutableLiveData<List<GuideName>>()
    val list : LiveData<List<GuideName>> = _list

    fun getServices(name: String){
        launchDataLoad(
            block = {
                _list.value = guideUseCase.getServicesByGuideName(name)
            },
            doOnError = {
                Log.e("DEBUG.TEST", "", it)
            }
        )
    }

}