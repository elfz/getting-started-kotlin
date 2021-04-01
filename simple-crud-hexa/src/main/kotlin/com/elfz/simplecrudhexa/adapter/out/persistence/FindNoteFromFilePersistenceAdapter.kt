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

    override fun findFrom(source: String, fileName: String) =
        s3Repository
            .findS3Object(source, fileName)
            .objectContent
                ?.let { InputStreamReader(it) }
                ?.let { BufferedReader(it) }
                ?.apply { readLine() } // ignore first line
                ?.let { it ->
                  it.lines()
                      ?.map {
                        val list = it.split(',')
                        val id = list[0].toLong()
                        val title = list[1]
                        val description = list[2]
                        NoteDomain(title, description, id)
                      }
                      ?.toList()
                }
                ?: emptyList()
}


