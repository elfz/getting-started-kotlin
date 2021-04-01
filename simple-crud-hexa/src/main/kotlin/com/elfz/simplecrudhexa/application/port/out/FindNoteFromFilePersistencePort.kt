package com.elfz.simplecrudhexa.application.port.out

import com.elfz.simplecrudhexa.application.domain.NoteDomain

interface FindNoteFromFilePersistencePort {

    fun findFrom(source: String, fileName:String): List<NoteDomain>
}