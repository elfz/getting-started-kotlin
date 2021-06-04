package com.elfz.webfluxutils

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxUtilsApplication

fun main(args: Array<String>) {
  runApplication<WebfluxUtilsApplication>(*args)
  val elfz = SoVai()
  elfz.first()
}
