package com.elfz.simplecrud.controller

import com.elfz.simplecrud.domain.Note
import com.elfz.simplecrud.repository.NoteRepository
import com.elfz.simplecrud.service.S3Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController(
    private val noteRepository: NoteRepository,
    private val s3Service: S3Service) {

    @PostMapping
    fun add(@RequestBody note: Note) = noteRepository.save(note)

    @GetMapping
    fun list() = noteRepository.findAll().toList()

    @GetMapping("/s3/download")
    fun downloadCsv(
        @RequestParam(required = true) bucketName: String,
        @RequestParam(required = true) fileName: String) {

        val notes = s3Service.downloadCsv(bucketName, fileName)
        noteRepository.saveAll(notes)
    }

}