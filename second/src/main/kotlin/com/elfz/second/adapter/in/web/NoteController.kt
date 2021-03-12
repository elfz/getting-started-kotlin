package com.elfz.second.adapter.`in`.web

import com.elfz.second.adapter.out.persistence.NoteEntity
import com.elfz.second.adapter.out.persistence.NoteRepository
import com.elfz.second.application.port.`in`.SaveNoteUseCase
import com.elfz.second.application.service.SaveNoteUseCaseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController(
    private val saveNoteUseCase: SaveNoteUseCase
) {

    @PostMapping
    fun add(@RequestBody noteRequest: NoteRequest) =
        saveNoteUseCase.save(noteRequest.toNoteDomain())

//    @GetMapping
//    fun list() = noteRepository.findAll().toList()

}