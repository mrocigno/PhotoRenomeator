package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo

interface ServiceUseCase {

    suspend fun save(list: List<Photo>)

    suspend fun getPhotos(guideName: GuideName):  List<Photo>

    suspend fun deletePhoto(photo: Photo)

}