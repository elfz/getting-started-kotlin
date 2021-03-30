package com.elfz.simplecrudhexa.application.service

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteUseCase
import com.elfz.simplecrudhexa.application.port.out.SaveNotePersistencePort
import org.springframework.stereotype.Service

@Service
class SaveNoteService(
    private val saveNotePersistencePort: SaveNotePersistencePort
) : SaveNoteUseCase {

    override fun save(noteDomain: NoteDomain) =
        saveNotePersistencePort.saveNote(noteDomain)

}