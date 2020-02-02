package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.repository.GuideRepository

class GuideUseCaseImpl(
    private val guideRepository: GuideRepository
) : GuideUseCase {

    override suspend fun getServicesByGuideName(name: String): List<Guide>{
        return guideRepository.listServicesByGuideName(name)
    }

}