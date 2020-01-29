package br.com.mrocigno.data.datasource

import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.domain.entity.GuideList

class GuideDataSourceImpl(
    private val guidesDao: GuidesDao
) : GuideDataSource.Local {

    override suspend fun listGuidesName(): List<GuideList> {
        return guidesDao.listGuidesName()
    }
}