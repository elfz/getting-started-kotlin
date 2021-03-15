package com.elfz.simplecrudhexa.application.port.out

import com.elfz.simplecrudhexa.application.domain.NoteDomain

interface FindNotePersistencePort {

    fun findAllNotes() : List<NoteDomain>
}