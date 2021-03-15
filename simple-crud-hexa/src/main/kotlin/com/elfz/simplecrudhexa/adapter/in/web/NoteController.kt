package com.elfz.simplecrudhexa.adapter.`in`.web

import com.elfz.simplecrudhexa.application.port.`in`.FindNoteUseCase
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController(
    private val saveNoteUseCase: SaveNoteUseCase,
    private val findNoteUseCase: FindNoteUseCase
) {

    @PostMapping
    fun add(@RequestBody noteRequest: NoteRequest) =
        saveNoteUseCase.save(noteRequest.toNoteDomain())

    @GetMapping
    fun list() =
            findNoteUseCase.findAll()
                    .map{ it.toNoteResponse() }

}