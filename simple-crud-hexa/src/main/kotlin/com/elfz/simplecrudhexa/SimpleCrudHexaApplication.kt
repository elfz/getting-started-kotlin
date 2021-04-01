package com.elfz.simplecrudhexa

import com.elfz.simplecrudhexa.properties.S3Properties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [S3Properties::class])
class SimpleCrudHexaApplication

fun main(args: Array<String>) {
    runApplication<SimpleCrudHexaApplication>(*args)
}
