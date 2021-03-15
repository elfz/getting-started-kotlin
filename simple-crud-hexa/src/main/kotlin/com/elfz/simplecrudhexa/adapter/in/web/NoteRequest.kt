package com.elfz.simplecrudhexa.adapter.`in`.web

import com.elfz.simplecrudhexa.adapter.out.persistence.NoteEntity
import com.elfz.simplecrudhexa.application.domain.NoteDomain

data class NoteRequest(

    val title: String,

    val description: String
)

fun NoteRequest.toNoteDomain() = NoteDomain(
    title = this.title,
    description = this.description
)

fun NoteDomain.toNoteEntity() = NoteEntity(
    title = this.title,
    description = this.description
)