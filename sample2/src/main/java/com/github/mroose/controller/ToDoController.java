package com.github.mroose.controller;

import com.github.mroose.dto.ToDo;
import com.github.mroose.service.ToDoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Tag(name = "ToDo")
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("/api/v1/todos")
    public Flux<ToDo> getTodos() {
        return toDoService.getTodos();
    }

    @GetMapping("/api/v1/todo/{id}")
    public Mono<ToDo> getTodo(@PathVariable Integer id) {
        return toDoService.getTodo(id);
    }
}