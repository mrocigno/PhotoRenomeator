package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.repository.GuideRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class GuideUseCaseImplTest {

    @MockK
    lateinit var repository: GuideRepository

    lateinit var guideUseCaseImpl: GuideUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        guideUseCaseImpl = GuideUseCaseImpl(repository)
    }

    @Test
    fun getServicesByGuideName() = runBlocking {
        coEvery {
            repository.listServicesByGuideName(any())
        } returns getListGuideName()

        val useCaseList = guideUseCaseImpl.getServicesByGuideName("")

        assertEquals(getListGuideName(), useCaseList)
    }

    private fun getListGuideName():List<GuideName>{
        return listOf(
            GuideName(
                fc = 1,
                name = "Teste",
                complement = "ap 1",
                countPhotos = 4,
                guide = "mrocigno - 20/12/2019",
                number = "20",
                rc = "501168436",
                streetName = "Rua Perova"
            )
        )
    }

}