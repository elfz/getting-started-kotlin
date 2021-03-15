package com.elfz.simplecrudhexa.application.service

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.FindNotePersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class FindNoteUseCaseServiceUnitTest(

) {

    @InjectMocks
    lateinit var useCase: FindNoteUseCaseService

    @Mock
    lateinit var findNotePersistencePort: FindNotePersistencePort

    @Test
    fun `test success`() {

        // Arrange
        val domains = buildDomains()

        Mockito.`when`(findNotePersistencePort.findAllNotes())
            .thenReturn(domains)

        // Act
        val result = useCase.findAll()

        // Assert
        assertThat(result)
            .isNotEmpty
            .hasSameSizeAs(domains)
            .containsAll(domains)

    }

    private fun buildNoteDomain() =
        NoteDomain(
            title = UUID.randomUUID().toString(),
            description = UUID.randomUUID().toString()
        )

    private fun buildDomains() =
        listOf(
            buildNoteDomain(),
            buildNoteDomain(),
            buildNoteDomain()
        )


}
