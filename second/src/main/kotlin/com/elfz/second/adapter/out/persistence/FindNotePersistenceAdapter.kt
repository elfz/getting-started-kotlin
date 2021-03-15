package com.elfz.second.adapter.out.persistence

import com.elfz.second.application.domain.NoteDomain
import com.elfz.second.application.port.out.FindNotePersistencePort
import org.springframework.stereotype.Component

@Component
class FindNotePersistenceAdapter(
        private val noteRepository: NoteRepository
) : FindNotePersistencePort {

    override fun findAllNotes(): List<NoteDomain> =
            noteRepository.findAll()
                    .map { it.toDomain() }

}