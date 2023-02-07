package com.github.mroose.controller;

import com.github.mroose.client.ToDoClient;
import com.github.mroose.dto.ToDo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ToDo")
public class ToDoController {

    private final ToDoClient toDoClient;

    @GetMapping("/api/v1/todos")
    public List<ToDo> getTodos() {
        return toDoClient.getTodos();
    }

    @GetMapping("/api/v1/todo/{id}")
    public ToDo getTodo(@PathVariable Integer id) {
        return toDoClient.getTodo(id);
    }
}