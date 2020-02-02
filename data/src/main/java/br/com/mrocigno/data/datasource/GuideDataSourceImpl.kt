package br.com.mrocigno.data.datasource

import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.data.mapper.GuideMapper
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList

class GuideDataSourceImpl(
    private val guidesDao: GuidesDao,
    private val guideMapper: GuideMapper.FromData
) : GuideDataSource.Local {

    override suspend fun listServicesByGuideName(name: String): List<Guide> {
        val services = guidesDao.listServicesByGuideName(name)
        return services.map {
            guideMapper.transform(it)
        }
    }

    override suspend fun listGuidesName(): List<GuideList> {
        return guidesDao.listGuidesName()
    }
}