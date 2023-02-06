package com.github.mroose.webflux.client;

import com.github.mroose.webflux.dto.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "jsonplaceholder")
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    List<Todo> getTodos();

    @RequestMapping(method = RequestMethod.GET, path = "/todos/{id}")
    Todo getTodo(Integer id);
}