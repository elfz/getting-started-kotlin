package com.elfz.reactiverestservice.hello

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class GreetingHandler(val downloadClient: DownloadClient) {

  fun hello(request: ServerRequest) : Mono<ServerResponse> {
    return ServerResponse
      .ok()
      .contentType(MediaType.TEXT_PLAIN)
      .body(BodyInserters.fromValue("Hello, Spring!"))
  }

  fun download(request: ServerRequest) : Mono<ServerResponse> {

    val responseM = downloadClient.download("http://localhost:8000/10-05-2021_Atualizada.csv");

    val response = responseM
      .map { "DEU BOM" }
      .switchIfEmpty(Mono.just("DEU RUIM"))

    return ServerResponse
      .ok()
      .contentType(MediaType.TEXT_PLAIN)
      .body(response)
  }

}
