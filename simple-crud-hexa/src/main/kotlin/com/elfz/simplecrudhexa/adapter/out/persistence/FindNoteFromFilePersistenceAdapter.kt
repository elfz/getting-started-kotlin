package com.elfz.simplecrudhexa.adapter.out.persistence

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.FindNoteFromFilePersistencePort
import org.springframework.stereotype.Component

@Component
class FindNoteFromFilePersistenceAdapter(
        private val s3Repository: S3Repository
): FindNoteFromFilePersistencePort {

    override fun findFrom(source: String, fileName: String): List<NoteDomain> {
        s3Repository.findS3Object(source, fileName).let {  }
    }
}