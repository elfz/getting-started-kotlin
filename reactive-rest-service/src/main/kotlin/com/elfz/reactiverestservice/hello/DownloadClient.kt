package com.elfz.reactiverestservice.hello

import org.springframework.core.io.buffer.DataBuffer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.DefaultUriBuilderFactory

@Component
class DownloadClient {

  fun download(url: String) =
    buildWebClient(url)
      .get()
      .retrieve()
      .bodyToMono(DataBuffer::class.java)


  private fun buildWebClient(url: String) = WebClient
    .builder()
    .uriBuilderFactory(
      DefaultUriBuilderFactory(url).also {
        it.encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE
      }
    )
    .exchangeStrategies(
      ExchangeStrategies
        .builder()
        .codecs { it.defaultCodecs().maxInMemorySize(16 * 1024 * 1024) }
        .build()
    )
    .build()

}
