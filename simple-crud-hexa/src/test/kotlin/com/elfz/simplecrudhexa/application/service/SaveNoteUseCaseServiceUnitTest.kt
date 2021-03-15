package com.elfz.simplecrudhexa.application.service

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.SaveNotePersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class SaveNoteUseCaseServiceUnitTest(

) {

    @InjectMocks
    lateinit var useCase: SaveNoteUseCaseService

    @Mock
    lateinit var saveNotePersistencePort: SaveNotePersistencePort

    @Test
    fun `test success`() {

        // Arrange
        val domain = NoteDomain(
            title = UUID.randomUUID().toString(),
            description = UUID.randomUUID().toString()
        )

        Mockito.`when`(saveNotePersistencePort.saveNote(domain))
            .thenReturn(domain)

        // Act
        val result = useCase.save(domain);

        // Assert
        assertThat(result)
            .isNotNull
            .usingRecursiveComparison()
            .isEqualTo(
                NoteDomain(title = domain.title, description = domain.description)
            )
    }

}
