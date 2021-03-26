package com.elfz.simplecrudhexa.adapter.out.persistence

import com.elfz.simplecrudhexa.adapter.out.persistence.note.SaveNotePersistenceAdapter
import com.elfz.simplecrudhexa.application.domain.NoteDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class SaveNotePersistenceAdapterTest {

    @InjectMocks
    lateinit var adapterSave: SaveNotePersistenceAdapter

    @Mock
    lateinit var noteRepository: NoteRepository

    @Test
    fun `test success`() {

        // Given
        val domain = NoteDomain(
            title = UUID.randomUUID().toString(),
            description = UUID.randomUUID().toString()
        )

        val entity = NoteEntity(
            title = domain.title,
            description = domain.description
        )

        Mockito.`when`(noteRepository.save(entity))
            .thenReturn(entity)

        // When
        val result = adapterSave.saveNote(domain)

        // Then
        assertThat(result)
            .isNotNull
            .usingRecursiveComparison()
            .isEqualTo(domain)

    }

}
