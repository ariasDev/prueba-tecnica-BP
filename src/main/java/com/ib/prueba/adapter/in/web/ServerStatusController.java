package com.ib.prueba.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/status")
public class ServerStatusController {

    @GetMapping
    Mono<String> getStatus() {
        return Mono.just("Server ok");
    }

}
