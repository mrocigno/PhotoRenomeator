package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.repository.GuideRepository

class GuideUseCaseImpl(
    private val guideRepository: GuideRepository
) : GuideUseCase {

    override suspend fun getServicesByGuideName(name: String): List<GuideName>{
        return guideRepository.listServicesByGuideName(name)
    }

}