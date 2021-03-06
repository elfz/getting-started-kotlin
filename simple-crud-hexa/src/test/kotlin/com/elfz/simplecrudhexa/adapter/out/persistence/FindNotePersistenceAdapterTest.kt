package com.elfz.simplecrudhexa.adapter.out.persistence

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
internal class FindNotePersistenceAdapterTest {

    @InjectMocks
    lateinit var adapterFind: FindNotePersistenceAdapter

    @Mock
    lateinit var noteRepository: NoteRepository

    @Test
    fun `test success`() {

        // Given
        val domains = listOf(
            buildNoteDomain(),
            buildNoteDomain(),
            buildNoteDomain()
        )

        val entities = domains.map {
            NoteEntity(
                title = it.title,
                description = it.description
            )
        }

        Mockito.`when`(noteRepository.findAll())
                .thenReturn(entities)

        // When
        val result = adapterFind.findAllNotes()

        // Then
        assertThat(result)
                .isNotEmpty
                .containsAll(domains)

    }

    private fun buildNoteDomain(): NoteDomain {
        return NoteDomain(
            title = UUID.randomUUID().toString(),
            description = UUID.randomUUID().toString()
        )
    }

}
