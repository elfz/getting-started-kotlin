package com.elfz.reactiverestservice

import com.elfz.reactiverestservice.hello.GreetingWebClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveRestServiceApplication

fun main(args: Array<String>) {
  runApplication<ReactiveRestServiceApplication>(*args)

  val client = GreetingWebClient()
  println(client.getResult())

}
