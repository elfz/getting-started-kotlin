package com.elfz.first

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class SomaController {

    val counter = AtomicLong();

    @GetMapping("/soma")
    fun soma(@RequestParam(value = "valor", defaultValue = "0") values: List<Int>) =
            Soma(counter.incrementAndGet(), values)

}