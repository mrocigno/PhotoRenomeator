package br.com.mrocigno.domain.repository

import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo

interface PhotoRepository {

    suspend fun savePhoto(list: List<Photo>)

    suspend fun listPhotos(guideName: GuideName): List<Photo>

    suspend fun deletePhoto(photo: Photo)

}