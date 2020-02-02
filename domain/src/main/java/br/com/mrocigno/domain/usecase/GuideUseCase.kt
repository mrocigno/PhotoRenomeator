package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideName

interface GuideUseCase {

    suspend fun getServicesByGuideName(name: String): List<GuideName>

}