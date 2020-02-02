package br.com.mrocigno.data.mapper

import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.infrastructure.net.Mapper

class GuideMapper {

    class FromData: Mapper<GuideData, Guide>() {

        override fun transform(item: GuideData?): Guide {
            return if(item == null){
                Guide()
            } else {
                Guide(
                    name = item.name,
                    type = item.type,
                    active = item.active,
                    city = item.city,
                    complement = item.complement,
                    country = item.country,
                    email = item.email,
                    fc = item.fc,
                    guide = item.guide,
                    latLng = item.latLng,
                    month = item.month,
                    moreInfo = item.moreInfo,
                    neighborhood = item.neighborhood,
                    number = item.number,
                    office = item.office,
                    people = item.people,
                    pg = item.pg,
                    phone = item.phone,
                    polo = item.polo,
                    poloDescription = item.poloDescription,
                    rc = item.rc,
                    receiveDate = item.receiveDate,
                    requester = item.requester,
                    responsible = item.responsible,
                    responsiblePhone = item.responsiblePhone,
                    sequence = item.sequence,
                    serviceDescription = item.serviceDescription,
                    serviceType = item.serviceType,
                    state = item.state,
                    streetName = item.streetName,
                    unity = item.unity,
                    users = item.users,
                    vatNumber = item.vatNumber,
                    zipCode = item.zipCode
                )
            }
        }

        override fun reverse(item: Guide?): GuideData {
            return if(item == null){
                GuideData()
            } else {
                GuideData(
                    name = item.name,
                    type = item.type,
                    active = item.active,
                    city = item.city,
                    complement = item.complement,
                    country = item.country,
                    email = item.email,
                    fc = item.fc,
                    guide = item.guide,
                    latLng = item.latLng,
                    month = item.month,
                    moreInfo = item.moreInfo,
                    neighborhood = item.neighborhood,
                    number = item.number,
                    office = item.office,
                    people = item.people,
                    pg = item.pg,
                    phone = item.phone,
                    polo = item.polo,
                    poloDescription = item.poloDescription,
                    rc = item.rc,
                    receiveDate = item.receiveDate,
                    requester = item.requester,
                    responsible = item.responsible,
                    responsiblePhone = item.responsiblePhone,
                    sequence = item.sequence,
                    serviceDescription = item.serviceDescription,
                    serviceType = item.serviceType,
                    state = item.state,
                    streetName = item.streetName,
                    unity = item.unity,
                    users = item.users,
                    vatNumber = item.vatNumber,
                    zipCode = item.zipCode
                )
            }
        }

    }

}