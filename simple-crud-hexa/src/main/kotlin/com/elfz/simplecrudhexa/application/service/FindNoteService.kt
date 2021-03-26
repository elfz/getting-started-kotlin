package com.elfz.simplecrudhexa.application.service

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.`in`.FindNoteUseCase
import com.elfz.simplecrudhexa.application.port.out.FindNotePersistencePort
import org.springframework.stereotype.Service

@Service
class FindNoteService(
        private val findNotePersistencePort: FindNotePersistencePort
) : FindNoteUseCase {

    override fun findAll(): List<NoteDomain> =
        findNotePersistencePort.findAllNotes()

}