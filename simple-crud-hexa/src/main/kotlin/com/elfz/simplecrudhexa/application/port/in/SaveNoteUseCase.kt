package com.elfz.simplecrudhexa.application.port.`in`

import com.elfz.simplecrudhexa.application.domain.NoteDomain

interface SaveNoteUseCase {

    fun save(noteDomain: NoteDomain): NoteDomain
}