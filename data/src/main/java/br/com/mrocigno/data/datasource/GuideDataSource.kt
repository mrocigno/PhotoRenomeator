package br.com.mrocigno.data.datasource

import br.com.mrocigno.domain.entity.GuideList

interface GuideDataSource {

    interface Remote

    interface Local {

        suspend fun listGuidesName() : List<GuideList>

    }

}