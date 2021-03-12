package com.elfz.second.application.service

import com.elfz.second.application.domain.NoteDomain
import com.elfz.second.application.port.`in`.SaveNoteUseCase
import com.elfz.second.application.port.out.SaveNotePersistencePort
import org.springframework.stereotype.Service

@Service
class SaveNoteUseCaseService(
    private val saveNotePersistencePort: SaveNotePersistencePort
) : SaveNoteUseCase {

    override fun save(noteDomain: NoteDomain) =
        saveNotePersistencePort.saveNote(noteDomain)

}