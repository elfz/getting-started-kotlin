package com.elfz.simplecrudhexa.application.service

import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteFromFileUseCase
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteUseCase
import com.elfz.simplecrudhexa.application.port.out.FindNoteFromFilePersistencePort
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class SaveNoteFromFileService(
        private val findNoteFromFilePersistencePort: FindNoteFromFilePersistencePort,
        private val saveNoteUseCase: SaveNoteUseCase
): SaveNoteFromFileUseCase {

    override fun save(source: String, fileName: String) {
        findNoteFromFilePersistencePort.findFrom(source, fileName).forEach{
            saveNoteUseCase.save(it)
        }
    }
}