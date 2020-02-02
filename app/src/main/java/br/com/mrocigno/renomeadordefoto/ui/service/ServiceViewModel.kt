package br.com.mrocigno.renomeadordefoto.ui.service

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo
import br.com.mrocigno.domain.usecase.ServiceUseCase
import br.com.mrocigno.infrastructure.base.AbstractViewModel
import br.com.mrocigno.infrastructure.utils.PicturesUtils
import java.io.File

class ServiceViewModel(
    private val serviceUseCase: ServiceUseCase
) : AbstractViewModel() {

    var guide : GuideName? = null
    val photo1 = MutableLiveData<Photo>()
    val photo2 = MutableLiveData<Photo>()
    val photo3 = MutableLiveData<Photo>()
    val photo4 = MutableLiveData<Photo>()
    val photo5 = MutableLiveData<Photo>()

    fun save(list: List<Photo>){
        launchDataLoad(
            block = {
                serviceUseCase.save(list)
            },
            doOnError = {
                Log.e("DEBUG TEST", "", it)
            }
        )
    }

    fun findPhotos(){
        launchDataLoad(
            block = {
                guide?.let {
                    val list = serviceUseCase.getPhotos(it)
                    repeat(list.size){ i ->
                        when(i){
                            0 -> photo1.value = list[i]
                            1 -> photo2.value = list[i]
                            2 -> photo3.value = list[i]
                            3 -> photo4.value = list[i]
                            4 -> photo5.value = list[i]
                        }
                    }
                }
            }
        )
    }

    fun deletePhoto(photo: Photo){
        launchDataLoad(
            block = {
                serviceUseCase.deletePhoto(photo)
                File(photo.path).delete()
            },
            doOnError = {
                Log.e("DEBUG TEST", "", it)
            }
        )
    }

}