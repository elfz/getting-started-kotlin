package com.elfz.second.application.service

import com.elfz.second.application.domain.NoteDomain
import com.elfz.second.application.port.`in`.FindNoteUseCase
import com.elfz.second.application.port.out.FindNotePersistencePort
import org.springframework.stereotype.Service

@Service
class FindNoteUseCaseService(
        private val findNotePersistencePort: FindNotePersistencePort
) : FindNoteUseCase {

    override fun findAll(): List<NoteDomain> =
        findNotePersistencePort.findAllNotes()

}