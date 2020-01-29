package br.com.mrocigno.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList

@Dao
interface GuidesDao {

    @Query("SELECT * FROM guides")
    suspend fun listAll() : List<Guide>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(guide: Guide)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(list : List<Guide>)

    @Query("SELECT guide, count(*) as countDo, 0 as countNotDo FROM guides GROUP BY guide")
    suspend fun listGuidesName() : List<GuideList>

}