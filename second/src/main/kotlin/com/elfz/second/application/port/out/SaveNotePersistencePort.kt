package com.elfz.second.application.port.out

import com.elfz.second.application.domain.NoteDomain


interface SaveNotePersistencePort {

    fun saveNote(noteDomain: NoteDomain): NoteDomain
}