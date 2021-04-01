package com.elfz.simplecrudhexa.adapter.out.persistence

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.FindNoteFromFilePersistencePort
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

@Component
class FindNoteFromFilePersistenceAdapter(
    private val s3Repository: S3Repository
) : FindNoteFromFilePersistencePort {

    override fun findFrom(source: String, fileName: String): List<NoteDomain> {
        val findS3Object = s3Repository.findS3Object(source, fileName)

        val inputStream = findS3Object.objectContent
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.readLine() // ignore first line

        return reader.lines()
            .map {
                val list = it.split(',')
                val id = list[0].toLong()
                val title = list[1]
                val description = list[2]
                NoteDomain(title, description, id)
            }.toList()
    }

}


