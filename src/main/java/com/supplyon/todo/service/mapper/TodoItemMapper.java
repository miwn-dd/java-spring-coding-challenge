package com.supplyon.todo.service.mapper;

import org.mapstruct.Mapper;

import com.supplyon.todo.data.models.TodoItem;
import com.supplyon.todo.service.to.TodoItemTO;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {
    TodoItem map(TodoItemTO todoItemTO);

    TodoItemTO map(TodoItem todoItem);
}
