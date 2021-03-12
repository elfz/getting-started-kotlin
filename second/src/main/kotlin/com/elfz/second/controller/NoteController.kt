package com.elfz.second.controller

import com.elfz.second.domain.Note
import com.elfz.second.repository.NoteRepository
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