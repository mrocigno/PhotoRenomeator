package br.com.mrocigno.data.mapper

import br.com.mrocigno.data.data.PhotoData
import br.com.mrocigno.domain.entity.Photo
import br.com.mrocigno.infrastructure.net.Mapper

class PhotoMapper {

    class FromData: Mapper<PhotoData, Photo>(){
        override fun transform(item: PhotoData?): Photo {
            return if(item == null){
                Photo(serviceId = 1)
            } else {
                Photo(
                    id = item.id,
                    serviceId = item.serviceId,
                    path = item.path,
                    createdDate = item.createdDate
                )
            }
        }

        override fun reverse(item: Photo?): PhotoData {
            return if(item == null){
                PhotoData(serviceId = 1)
            } else {
                PhotoData(
                    id = item.id,
                    serviceId = item.serviceId,
                    path = item.path,
                    createdDate = item.createdDate
                )
            }
        }

    }


}