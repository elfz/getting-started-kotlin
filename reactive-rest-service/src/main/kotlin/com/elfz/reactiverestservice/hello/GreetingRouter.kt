package com.elfz.reactiverestservice.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class GreetingRouter {

  @Bean
  fun route(greetingHandler: GreetingHandler): RouterFunction<ServerResponse> {
    return RouterFunctions
      .route(
        RequestPredicates.GET("/hello")
          .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
        greetingHandler::hello
      )
      .andRoute(
        RequestPredicates.GET("/download"), greetingHandler::download
      )

  }

}
