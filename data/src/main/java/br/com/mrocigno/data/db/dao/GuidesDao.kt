package br.com.mrocigno.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.domain.entity.GuideName

@Dao
interface GuidesDao {

    @Query("SELECT * FROM guides")
    suspend fun listAll() : List<GuideData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(guide: GuideData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(list : List<GuideData>)

    @Query("SELECT guide, count(*) as countDo, 0 as countNotDo FROM guides GROUP BY guide")
    suspend fun listGuidesName() : List<GuideList>

    @Query("SELECT fc, guide, name, rc, streetName, number, complement, (SELECT count(*) FROM photos p WHERE p.serviceId = g.fc) as countPhotos FROM guides g WHERE g.guide = :name")
    suspend fun listServicesByGuideName(name: String) : List<GuideName>

}