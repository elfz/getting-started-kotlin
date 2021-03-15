package com.elfz.simplecrudhexa.adapter.out.persistence

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.FindNotePersistencePort
import org.springframework.stereotype.Component

@Component
class FindNotePersistenceAdapter(
        private val noteRepository: NoteRepository
) : FindNotePersistencePort {

    override fun findAllNotes(): List<NoteDomain> =
            noteRepository.findAll()
                    .map { it.toDomain() }

}