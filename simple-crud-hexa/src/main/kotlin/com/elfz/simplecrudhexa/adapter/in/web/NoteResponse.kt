package com.elfz.simplecrudhexa.adapter.`in`.web

import com.elfz.simplecrudhexa.application.domain.NoteDomain

data class NoteResponse(

        val title: String,

        val description: String,

        val id: Long
)

fun NoteResponse.toNoteDomain() = NoteDomain(
    title = this.title,
    description = this.description,
    id = this.id
)

fun NoteDomain.toNoteResponse() = NoteResponse(
    title = this.title,
    description = this.description,
    id = this.id
)