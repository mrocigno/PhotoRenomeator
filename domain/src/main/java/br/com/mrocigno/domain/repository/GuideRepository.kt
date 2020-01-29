package br.com.mrocigno.domain.repository

import br.com.mrocigno.domain.entity.GuideList

interface GuideRepository {

    suspend fun listGuidesName() : List<GuideList>

}