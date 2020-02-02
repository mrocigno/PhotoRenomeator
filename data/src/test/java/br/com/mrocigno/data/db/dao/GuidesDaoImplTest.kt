package br.com.mrocigno.data.db.dao

import android.content.Context
import android.os.Build
import androidx.room.Room
import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.data.db.AppDatabase
import br.com.mrocigno.data.db.dao.TestDaoUtils.Companion.createGuide
import br.com.mrocigno.domain.entity.GuideList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class GuidesDaoImplTest {

    private lateinit var guideDao: GuidesDao
    private lateinit var db: AppDatabase

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val context : Context = RuntimeEnvironment.systemContext
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        guideDao = db.guidesDao()
    }

    @Test
    fun insertOne() = runBlocking {
        val guide = createGuide(1)[0]
        guideDao.insertOne(guide)

        val result = guideDao.listAll()
        Assert.assertEquals(result.size, 1)
        Assert.assertEquals(result, createGuide(1))
    }

    @Test
    fun insertMany() = runBlocking{
        val guide = createGuide(5)
        guideDao.insertMany(guide)

        val result = guideDao.listAll()
        Assert.assertEquals(result.size, 5)
        Assert.assertEquals(result, createGuide(5))
    }

    @Test
    fun listAll() = runBlocking{
        var result = guideDao.listAll()
        assert(result.isEmpty())

        guideDao.insertMany(createGuide(5))
        result = guideDao.listAll()
        assert(result.size == 5)
    }

    @Test
    fun listGuidesName() = runBlocking{
        guideDao.insertMany(createGuide(5))
        val result = guideDao.listGuidesName()
        Assert.assertEquals(result.size, 1)
        Assert.assertEquals(result, listOf(
            GuideList(
                guide = "mrocino - 20/01/2014",
                countDo = "5",
                countNotDo = 0
            )
        ))
    }

    @Test
    fun listServicesByGuideName() = runBlocking {
        guideDao.insertMany(createGuide(5))
        var result = guideDao.listServicesByGuideName("test")
        assert(result.isEmpty())

        result = guideDao.listServicesByGuideName("mrocino - 20/01/2014")
        assert(result.size == 5)
    }

    @After
    fun closeDb() {
        db.close()
    }


}