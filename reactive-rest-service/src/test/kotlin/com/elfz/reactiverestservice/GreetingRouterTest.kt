package com.elfz.reactiverestservice

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingRouterTest(@Autowired private val webTestClient: WebTestClient) {

  @Test
  fun testHello(){
    webTestClient
      .get().uri("/hello")
      .accept(MediaType.TEXT_PLAIN)
      .exchange()
      .expectStatus().isOk
      .expectBody<String>()
      .isEqualTo("Hello, Spring!")
  }



}
