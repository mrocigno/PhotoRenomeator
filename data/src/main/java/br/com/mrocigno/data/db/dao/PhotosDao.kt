package br.com.mrocigno.data.db.dao

import androidx.room.*
import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.data.data.PhotoData
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.domain.entity.GuideList

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photos")
    suspend fun listAll() : List<PhotoData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(guide: PhotoData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(list : List<PhotoData>)

    @Query("SELECT * FROM photos WHERE serviceId = :serviceId")
    suspend fun listByServiceId(serviceId: Int) : List<PhotoData>

    @Delete
    suspend fun delete(photo: PhotoData)

}