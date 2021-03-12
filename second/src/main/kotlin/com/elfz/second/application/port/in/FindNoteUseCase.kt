package com.elfz.second.application.port.`in`

import com.elfz.second.application.domain.NoteDomain

interface FindNoteUseCase {

    fun findAll(): List<NoteDomain>
}