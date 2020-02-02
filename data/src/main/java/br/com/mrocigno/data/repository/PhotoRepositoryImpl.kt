package br.com.mrocigno.data.repository

import br.com.mrocigno.data.datasource.PhotoDataSource
import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo
import br.com.mrocigno.domain.repository.PhotoRepository

class PhotoRepositoryImpl(
    private val photoDataSourceLocal: PhotoDataSource.Local
): PhotoRepository {

    override suspend fun savePhoto(list: List<Photo>) {
        photoDataSourceLocal.savePhoto(list)
    }

    override suspend fun listPhotos(guideName: GuideName): List<Photo> {
        return photoDataSourceLocal.listPhotos(guideName)
    }

    override suspend fun deletePhoto(photo: Photo) {
        photoDataSourceLocal.deletePhoto(photo)
    }

}