package com.elfz.simplecrud.controller

import com.elfz.simplecrud.domain.Note
import com.elfz.simplecrud.repository.NoteRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NoteControllerTest (
    @Autowired private val noteRepository: NoteRepository,
    @Autowired private val webClient: WebTestClient
        ){

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    fun `Save test`() {
        val note = Note(title = "titulo", description = "descricao")

        webClient.post()
                .uri("/notes")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(note), Note::class.java)
                .exchange()
                .expectStatus().isOk
                .expectBody()

        noteRepository.findById(note.id)
                .map {
                    assertThat(it.title).isEqualTo(note.title)
                    assertThat(it.description).isEqualTo(note.description)
                }

    }
}