package br.com.mrocigno.data.datasource

import android.util.Log
import br.com.mrocigno.data.db.dao.PhotosDao
import br.com.mrocigno.data.mapper.PhotoMapper
import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo

class PhotoDataSourceImpl(
    private val photosDao: PhotosDao,
    private val photosMapper: PhotoMapper.FromData
): PhotoDataSource.Local {

    override suspend fun savePhoto(list: List<Photo>) {
        photosDao.insertMany(list.map {
            photosMapper.reverse(it)
        })
    }

    override suspend fun listPhotos(guideName: GuideName): List<Photo> {
        return photosDao.listByServiceId(guideName.fc).map {
            photosMapper.transform(it)
        }
    }

    override suspend fun deletePhoto(photo: Photo) {
        photosDao.delete(photosMapper.reverse(photo))
    }


}