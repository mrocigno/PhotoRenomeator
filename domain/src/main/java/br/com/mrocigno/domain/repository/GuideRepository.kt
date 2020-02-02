package br.com.mrocigno.domain.repository

import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList

interface GuideRepository {

    suspend fun listGuidesName() : List<GuideList>

    suspend fun listServicesByGuideName(name: String): List<Guide>

}