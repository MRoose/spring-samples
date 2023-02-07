package com.github.mroose.service;

import com.github.mroose.dto.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final WebClient webClient;

    public Flux<ToDo> getTodos() {
        return webClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/todos")
                .retrieve()
                .bodyToFlux(ToDo.class);
    }

    public Mono<ToDo> getTodo(Integer id) {
        return webClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/todos/" + id)
                .retrieve()
                .bodyToMono(ToDo.class);
    }
}