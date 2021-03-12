package com.elfz.second.application.port.`in`

import com.elfz.second.application.domain.NoteDomain

interface SaveNoteUseCase {

    fun save(noteDomain: NoteDomain): NoteDomain
}