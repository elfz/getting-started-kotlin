package com.elfz.simplecrudhexa.adapter.out.persistence

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.S3Object
import com.elfz.simplecrudhexa.properties.S3Properties
import org.springframework.stereotype.Component

@Component
class S3RepositoryImpl(
    private val s3Properties: S3Properties
) : S3Repository {

  private val s3Client =
      AmazonS3ClientBuilder
          .standard()
          .withCredentials(
              AWSStaticCredentialsProvider(
                  BasicAWSCredentials(s3Properties.accessKey, s3Properties.secretKey)
              )
          )
          .withEndpointConfiguration(
              EndpointConfiguration(s3Properties.endpoint, s3Properties.region)
          )
          .build()

  override fun findS3Object(bucketName: String, fileName: String): S3Object {
    return s3Client.getObject(bucketName, fileName)
  }
}