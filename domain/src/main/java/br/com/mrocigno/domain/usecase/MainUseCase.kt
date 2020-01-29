package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.GuideList

interface MainUseCase {

    suspend fun listGuidesName() : List<GuideList>

}