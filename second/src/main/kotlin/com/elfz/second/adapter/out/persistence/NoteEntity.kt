package com.elfz.second.adapter.out.persistence

import com.elfz.second.application.domain.NoteDomain
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class NoteEntity (
    @Id
    @GeneratedValue
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

fun NoteEntity.toDomain()= NoteDomain(
    title = this.title,
    description = this.description,
    id = this.id
)

fun NoteDomain.toEntity()= NoteEntity(
    title = this.title,
    description = this.description,
    id = this.id
)
