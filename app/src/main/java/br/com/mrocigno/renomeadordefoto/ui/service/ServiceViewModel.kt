package br.com.mrocigno.renomeadordefoto.ui.service

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import br.com.mrocigno.infrastructure.base.AbstractViewModel

class ServiceViewModel : AbstractViewModel() {

    val photo1 = MutableLiveData<Bitmap>()
    val photo2 = MutableLiveData<Bitmap>()
    val photo3 = MutableLiveData<Bitmap>()
    val photo4 = MutableLiveData<Bitmap>()
    val photo5 = MutableLiveData<Bitmap>()

}