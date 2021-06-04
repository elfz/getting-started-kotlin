package com.elfz.reactiverestservice.hello

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient


class GreetingWebClient {
  private val client = WebClient.create("http://localhost:8080")

  private val result = client.get()
    .uri("/hello")
    .accept(MediaType.TEXT_PLAIN)
    .retrieve()
    .bodyToMono(String::class.java)

  fun getResult(): String {

    val responseString = result
      .block()

    return ">> result = $responseString"

  }


}
