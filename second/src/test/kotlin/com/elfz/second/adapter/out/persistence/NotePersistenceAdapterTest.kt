package com.elfz.second.adapter.out.persistence

import com.elfz.second.application.domain.NoteDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class NotePersistenceAdapterTest() {

    @InjectMocks
    lateinit var adapter: NotePersistenceAdapter

    @Mock
    lateinit var noteRepository: NoteRepository

    @Test
    fun `NotePersistenceAdapterTest test success`() {

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
        val result = adapter.saveNote(domain)

        // Then
        assertThat(result)
            .isNotNull
            .usingRecursiveComparison()
            .isEqualTo(domain)

    }

}
