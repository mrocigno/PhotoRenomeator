package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo
import br.com.mrocigno.domain.repository.PhotoRepository

class ServiceUseCaseImpl(
    private val photoRepository: PhotoRepository
) : ServiceUseCase {

    override suspend fun save(list: List<Photo>){
        photoRepository.savePhoto(list)
    }

    override suspend fun getPhotos(guideName: GuideName) :List<Photo> {
        return photoRepository.listPhotos(guideName)
    }

    override suspend fun deletePhoto(photo: Photo) {
        photoRepository.deletePhoto(photo)
    }

}