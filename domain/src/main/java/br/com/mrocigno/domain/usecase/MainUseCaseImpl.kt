package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.domain.repository.GuideRepository

class MainUseCaseImpl(
    private val guideRepository: GuideRepository
) : MainUseCase {

    override suspend fun listGuidesName(): List<GuideList> {
        return guideRepository.listGuidesName()
    }


}