package com.elfz.second.application.port.out

import com.elfz.second.application.domain.NoteDomain

interface FindNotePersistencePort {

    fun findAllNotes() : List<NoteDomain>
}