package com.elfz.simplecrud.controller

import com.elfz.simplecrud.domain.Note
import com.elfz.simplecrud.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController(private val noteRepository: NoteRepository) {

    @PostMapping
    fun add(@RequestBody note: Note) = noteRepository.save(note)

    @GetMapping
    fun list() = noteRepository.findAll().toList()

}