package com.elfz.simplecrudhexa.adapter.`in`.web

import com.elfz.simplecrudhexa.application.port.`in`.FindNoteUseCase
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteFromFileUseCase
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController(
    private val saveNoteUseCase: SaveNoteUseCase,
    private val findNoteUseCase: FindNoteUseCase,
    private val saveNoteFromFileUseCase: SaveNoteFromFileUseCase
) {

    @PostMapping
    fun save(@RequestBody noteRequest: NoteRequest) =
        saveNoteUseCase.save(noteRequest.toNoteDomain())

    @GetMapping
    fun find() =
            findNoteUseCase.findAll()
                    .map{ it.toNoteResponse() }

    @PostMapping("/s3/")
    fun save(
            @RequestParam(required = true) bucketName: String,
            @RequestParam(required = true) fileName: String) {
        saveNoteFromFileUseCase.save(bucketName, fileName)
    }
}