package com.github.mroose.client;

import com.github.mroose.dto.ToDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ToDoClient", url = "http://jsonplaceholder.typicode.com")
public interface ToDoClient {

    @GetMapping("/todos")
    List<ToDo> getTodos();

    @GetMapping("/todos/{id}")
    ToDo getTodo(@PathVariable Integer id);
}