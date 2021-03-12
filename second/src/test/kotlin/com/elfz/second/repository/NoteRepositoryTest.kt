package com.elfz.second.repository

import com.elfz.second.domain.Note
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class NoteRepositoryTest(@Autowired private val noteRepository: NoteRepository) {

    @Test
    fun `Test Save`() {
        val note = Note(title = "titulo", description = "descricao")
        noteRepository.save(note)
        val noteSaved = noteRepository.findById(note.id).get()
        assertThat(note.id).isEqualTo(noteSaved.id)
        assertThat(note.title).isEqualTo(noteSaved.title)
        assertThat(note.description).isEqualTo(noteSaved.description)
    }

    @Test
    fun `Test Find All`() {
        val notes = listOf(
                Note(title = "titulo", description = "descricao"),
                Note(title = "titulo", description = "descricao"),
                Note(title = "titulo", description = "descricao"))

        noteRepository.saveAll(notes)

        val notesSaved = noteRepository.findAll().toList()
        assertThat(notesSaved).isNotEmpty
        assertThat(notes.size).isEqualTo(notesSaved.size)
    }

}