package br.com.mrocigno.data.mapper

import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.domain.entity.Guide
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GuideMapperTest {

    private lateinit var mapperData : GuideMapper.FromData

    @Before
    fun setUp(){
        mapperData = GuideMapper.FromData()
    }

    @Test
    fun transformTest(){
        val test = mapperData.transform(createGuideData())
        assertEquals(test, createGuide())
    }

    @Test
    fun reverseTest(){
        val test = mapperData.reverse(createGuide())
        assertEquals(test, createGuideData())
    }

    private fun createGuide(): Guide {
        return Guide(
            fc = 1,
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
    }

    private fun createGuideData(): GuideData {
        return GuideData(
            fc = 1,
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
    }
}