package com.supplyon.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supplyon.todo.service.TodoItemService;
import com.supplyon.todo.service.to.TodoItemTO;

@RestController
@RequestMapping("/todo-items")
public class TodoItemController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<TodoItemTO> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TodoItemTO createTodoItem(@RequestBody TodoItemTO todoItemTO) {
        return todoItemService.createTodoItem(todoItemTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public TodoItemTO updateTodoItem(
        @PathVariable Long id,
        @RequestBody TodoItemTO todoItemTO
    ) {
        return todoItemService.updateTodoItem(id, todoItemTO);
    }
}
