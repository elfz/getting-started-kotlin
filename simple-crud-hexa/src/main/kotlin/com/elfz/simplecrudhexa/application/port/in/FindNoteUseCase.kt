package com.elfz.simplecrudhexa.application.port.`in`

import com.elfz.simplecrudhexa.application.domain.NoteDomain

interface FindNoteUseCase {

    fun findAll(): List<NoteDomain>
}