package com.elfz.simplecrudhexa.adapter.out.persistence

import com.amazonaws.services.s3.model.S3Object
import org.springframework.stereotype.Repository

@Repository
interface S3Repository {

    fun findS3Object(bucketName: String, fileName: String): S3Object
}