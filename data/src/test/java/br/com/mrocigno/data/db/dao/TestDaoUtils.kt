package br.com.mrocigno.data.db.dao

import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.data.data.PhotoData

class TestDaoUtils {

    companion object {

        fun createPhoto(num: Int): List<PhotoData>{
            val list = arrayListOf<PhotoData>()
            repeat(num){
                list.add(
                    PhotoData(
                        id = it,
                        serviceId = 1,
                        path = "path",
                        createdDate = "2020-01-01"
                    )
                )
            }
            return list
        }

        fun createGuide(num: Int): List<GuideData> {
            val list = arrayListOf<GuideData>()
            repeat(num){
                list.add(
                    GuideData(
                        fc = it,
                        streetName = "Rua perova",
                        rc = "156132335",
                        number = "22",
                        guide = "mrocino - 20/01/2014",
                        complement = "ap 4",
                        name = "001 - TESTE",
                        active = "1",
                        city = "São Paulo",
                        country = "Brasil",
                        email = "rocignom@gmail.com",
                        latLng = "00, 00",
                        month = "março",
                        moreInfo = "str + rdf",
                        neighborhood = "Penha",
                        office = "Dev",
                        people = "MATHEUS; EMERSON",
                        pg = "104",
                        phone = "11976274020",
                        polo = "Sao miguel",
                        poloDescription = "",
                        receiveDate = "20/01/2019",
                        requester = "Ivan",
                        responsible = "Ivan",
                        responsiblePhone = "11985472356",
                        sequence = 1,
                        serviceDescription = "CAPA ASFALTICA",
                        serviceType = "Rede",
                        state = "SP",
                        type = "Red",
                        unity = "14",
                        users = "mrocigno",
                        vatNumber = "587423135",
                        zipCode = "03710120"
                    )
                )
            }
            return list
        }

    }

}