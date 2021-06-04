package com.elfz.reactiverestservice

import WireMockContextInitializer
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [WireMockContextInitializer::class])
class GreetingRouter4Test(
  @Autowired private val webTestClient: WebTestClient,
  @Autowired private val wireMockServer: WireMockServer
) {

  @Test
  fun testDownload(){

    val url = "http://localhost:8000/10-05-2021_Atualizada.csv"

    stubResponse(url, "nao eh possivel")

    webTestClient
      .get().uri("/download")
      .accept(MediaType.TEXT_PLAIN)
      .exchange()
      .expectStatus().isOk
      .expectBody<String>()
      .isEqualTo("DEU BOM")

//    verify(getRequestedFor(urlEqualTo("/hello")))
  }

  private fun stubResponse(url: String, responseBody: String, responseStatus: Int = HttpStatus.OK.value()) {
    wireMockServer.stubFor(get(anyUrl())
      .willReturn(
        aResponse()
          .withStatus(responseStatus)
          .withBody(responseBody))
    )
  }



}
