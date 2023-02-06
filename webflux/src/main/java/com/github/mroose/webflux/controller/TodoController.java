package com.github.mroose.webflux.controller;

import com.github.mroose.webflux.dto.Todo;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
public class TodoController {

    private final WebClient jphWebClient;

    public TodoController(WebClient jspWebClient) {
        this.jphWebClient = jspWebClient;
    }

    @GetMapping("/api/v1/todos")
    public Flux<Todo> getTodos(@RequestParam(required = false) Integer userId,
                               @RequestParam(required = false) Integer id,
                               @RequestParam(required = false) String title,
                               @RequestParam(required = false) Boolean completed) {
        return jphWebClient
            .get()
            .uri(e -> e
                .path("/todos")
                .queryParamIfPresent("userId", Optional.ofNullable(userId))
                .queryParamIfPresent("id", Optional.ofNullable(id))
                .queryParamIfPresent("title", Optional.ofNullable(title))
                .queryParamIfPresent("completed", Optional.ofNullable(completed))
                .build()
            )
            .retrieve()
            .bodyToFlux(Todo.class);
    }
}