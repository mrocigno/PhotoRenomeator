package br.com.mrocigno.data.db.dao

import android.content.Context
import android.os.Build
import androidx.room.Room
import br.com.mrocigno.data.db.AppDatabase
import br.com.mrocigno.data.db.dao.TestDaoUtils.Companion.createGuide
import br.com.mrocigno.data.db.dao.TestDaoUtils.Companion.createPhoto
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class PhotosDaoImplTest {

    private lateinit var photosDao: PhotosDao
    private lateinit var db: AppDatabase

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val context : Context = RuntimeEnvironment.systemContext
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        photosDao = db.photosDao()
    }

    @Test
    fun insertOne() = runBlocking {
        photosDao.insertOne(createPhoto(1)[0])

        val result = photosDao.listAll()
        assertEquals(result.size, 1)
        assertEquals(result, createPhoto(1))
    }

    @Test
    fun insertMany() = runBlocking {
        photosDao.insertMany(createPhoto(5))

        val result = photosDao.listAll()
        assertEquals(result.size, 5)
        assertEquals(result, createPhoto(5))
    }

    @Test
    fun delete() = runBlocking {
        photosDao.insertMany(createPhoto(5))
        var result = photosDao.listAll()
        assertEquals(result.size, 5)

        photosDao.delete(createPhoto(1)[0])
        result = photosDao.listAll()
        assertEquals(result.size, 4)
    }

    @Test
    fun listAll() = runBlocking {
        var result = photosDao.listAll()
        assert(result.isEmpty())

        photosDao.insertMany(createPhoto(5))
        result = photosDao.listAll()
        assert(result.size == 5)
    }

    @Test
    fun listByServiceId() = runBlocking {
        photosDao.insertMany(createPhoto(5))
        var result = photosDao.listByServiceId(0)
        assert(result.isEmpty())

        result = photosDao.listByServiceId(1)
        assert(result.size == 5)
    }

    @After
    fun closeDb() {
        db.close()
    }
}