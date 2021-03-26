package com.elfz.simplecrudhexa.adapter.out.persistence

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.out.SaveNotePersistencePort
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
class SaveNotePersistenceAdapter(
    private val repository: NoteRepository
) : SaveNotePersistencePort {

    override fun saveNote(noteDomain: NoteDomain) =
        noteDomain.toEntity()
            .let { repository.save(it) }
            .toDomain()
}

//class S3Service {
//
//    fun downloadCsv(bucketName: String, fileName: String) : List<Note> {
//        val credentials: AWSCredentials = BasicAWSCredentials(
//                "test",
//                "test"
//        )
//
//        val endpoint = AwsClientBuilder.EndpointConfiguration("http://0.0.0.0:4566", "us-east-1")
//
//        // Create s3 client
//        val s3Client = AmazonS3ClientBuilder
//                .standard()
//                .withCredentials(AWSStaticCredentialsProvider(credentials))
//                .withEndpointConfiguration(endpoint)
//                .build()
//
//        val s3object: S3Object = s3Client.getObject(bucketName, fileName)
//        val inputStream = s3object.objectContent
//        val reader = BufferedReader(InputStreamReader(inputStream))
//        val it = 0;
//        reader.readLine() // ignore first line
//
//        return reader.lines()
//                .map{
//                    val list = it.split(',')
//                    Note(list[0].toLong(), list[1], list[2])
//                }
//                .toList()
//    }
//
//}