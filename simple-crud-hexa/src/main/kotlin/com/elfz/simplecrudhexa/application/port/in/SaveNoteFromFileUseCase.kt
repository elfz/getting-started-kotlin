package com.elfz.simplecrudhexa.application.port.`in`

import com.elfz.simplecrudhexa.application.domain.NoteDomain

interface SaveNoteFromFileUseCase {

    fun save(source: String, fileName: String): List<NoteDomain>
}