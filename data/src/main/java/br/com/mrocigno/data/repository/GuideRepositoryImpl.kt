package br.com.mrocigno.data.repository

import br.com.mrocigno.data.datasource.GuideDataSource
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.repository.GuideRepository

class GuideRepositoryImpl(
    private val guideDataSourceLocal: GuideDataSource.Local
) : GuideRepository {

    override suspend fun listServicesByGuideName(name: String): List<GuideName> {
        return guideDataSourceLocal.listServicesByGuideName(name)
    }

    override suspend fun listGuidesName(): List<GuideList> {
        return guideDataSourceLocal.listGuidesName()
    }

}