package br.com.mrocigno.data.datasource

import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo

interface PhotoDataSource {

    interface Local {

        suspend fun savePhoto(list: List<Photo>)

        suspend fun listPhotos(guideName: GuideName): List<Photo>

        suspend fun deletePhoto(photo: Photo)

    }

}