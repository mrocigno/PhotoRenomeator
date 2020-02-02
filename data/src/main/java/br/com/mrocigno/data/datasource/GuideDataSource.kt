package br.com.mrocigno.data.datasource

import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.domain.entity.GuideName

interface GuideDataSource {

    interface Remote

    interface Local {

        suspend fun listGuidesName() : List<GuideList>

        suspend fun listServicesByGuideName(name: String): List<GuideName>

    }

}