package br.com.mrocigno.data.repository

import br.com.mrocigno.data.datasource.GuideDataSource
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.domain.repository.GuideRepository

class GuideRepositoryImpl(
    private val guideDataSourceLocal: GuideDataSource.Local
) : GuideRepository {

    override suspend fun listGuidesName(): List<GuideList> {
        return guideDataSourceLocal.listGuidesName()
    }

}