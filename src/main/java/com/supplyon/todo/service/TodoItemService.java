package com.supplyon.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplyon.todo.data.models.TodoItem;
import com.supplyon.todo.data.repositories.TodoItemRepository;
import com.supplyon.todo.service.mapper.TodoItemMapper;
import com.supplyon.todo.service.to.TodoItemTO;

@Service("TodoItemService")
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private TodoItemMapper todoItemMapper;

    public TodoItemTO createTodoItem(TodoItemTO todoItemTO) {
        TodoItem todoItem = todoItemMapper.map(todoItemTO);

        todoItemRepository.save(todoItem);

        return todoItemMapper.map(todoItem);
    }

    public TodoItemTO updateTodoItem(Long id, TodoItemTO todoItemTO) {
        TodoItem todoItem = todoItemRepository.getOne(id);

        todoItem.setTaskName(todoItemTO.getTaskName());
        todoItem.setDone(todoItemTO.getDone());

        todoItemRepository.save(todoItem);

        return todoItemMapper.map(todoItem);
    }


    public List<TodoItemTO> getAllTodoItems() {
        return todoItemRepository.findAll().stream()
            .map(todoItem -> todoItemMapper.map(todoItem))
            .collect(Collectors.toList());
    }




}
