package com.elfz.simplecrudhexa.adapter.out.persistence

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.SaveNotePersistencePort
import org.springframework.stereotype.Component

@Component
class SaveNotePersistenceAdapter(
    private val repository: NoteRepository
) : SaveNotePersistencePort {

    override fun saveNote(noteDomain: NoteDomain) =
        noteDomain.toEntity()
            .let { repository.save(it) }
            .toDomain()
}