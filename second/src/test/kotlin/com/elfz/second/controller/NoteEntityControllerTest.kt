package com.elfz.second.controller

import com.elfz.second.adapter.`in`.web.NoteResponse
import com.elfz.second.adapter.out.persistence.NoteEntity
import com.elfz.second.adapter.out.persistence.NoteRepository
import com.elfz.second.application.domain.NoteDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList
import reactor.core.publisher.Mono
import javax.transaction.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NoteEntityControllerTest (
    @Autowired private val noteRepository: NoteRepository,
    @Autowired private val webClient: WebTestClient
        ){

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    fun `Save test success`() {
        val note = NoteEntity(title = "titulo", description = "descricao")

        webClient.post()
                .uri("/notes")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(note), NoteEntity::class.java)
                .exchange()
                .expectStatus().isOk
                .expectBody()

        noteRepository.findById(note.id)
                .map {
                    assertThat(it.title).isEqualTo(note.title)
                    assertThat(it.description).isEqualTo(note.description)
                }

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    fun `Find All Test success` () {

        // Given
        val notes = listOf(
                NoteEntity(title = "titulo", description = "descricao"),
                NoteEntity(title = "titulo", description = "descricao"),
                NoteEntity(title = "titulo", description = "descricao")
        )
        noteRepository.saveAll(notes)

        // When
        webClient.get()
                .uri("/notes")
                .exchange()
                // Then
                .expectStatus().isOk
                .expectBodyList<NoteResponse>()
                .hasSize(notes.size)
                .contains(NoteResponse(
                    description = notes[0].description,
                    title = notes[0].title,
                    id = notes[0].id
                ))

    }
}