package com.elfz.simplecrud.service

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.S3Object
import com.elfz.simplecrud.domain.Note
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

@Service
class S3Service {

  fun downloadCsv(bucketName: String, fileName: String) : List<Note> {
    val credentials: AWSCredentials = BasicAWSCredentials(
        "test",
        "test"
    )

    val endpoint = AwsClientBuilder.EndpointConfiguration("http://0.0.0.0:4566", "us-east-1")

    // Create s3 client
    val s3Client = AmazonS3ClientBuilder
        .standard()
        .withCredentials(AWSStaticCredentialsProvider(credentials))
        .withEndpointConfiguration(endpoint)
        .build()

    val s3object: S3Object = s3Client.getObject(bucketName, fileName)
    val inputStream = s3object.objectContent
    val reader = BufferedReader(InputStreamReader(inputStream))
    val it = 0;
    reader.readLine() // ignore first line

    return reader.lines()
        .map{
          val list = it.split(',')
          Note(list[0].toLong(), list[1], list[2])
        }
        .toList()
  }

}