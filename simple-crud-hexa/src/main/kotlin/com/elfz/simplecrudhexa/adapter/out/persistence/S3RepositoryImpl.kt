package com.elfz.simplecrudhexa.adapter.out.persistence

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.S3Object
import org.springframework.stereotype.Component

@Component
class S3RepositoryImpl: S3Repository {

    override fun findS3Object(bucketName: String, fileName: String): S3Object {
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

        return s3Client.getObject(bucketName, fileName)
    }
}