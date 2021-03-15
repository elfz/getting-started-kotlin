package com.elfz.simplecrudhexa.application.port.out

import com.elfz.simplecrudhexa.application.domain.NoteDomain


interface SaveNotePersistencePort {

    fun saveNote(noteDomain: NoteDomain): NoteDomain
}