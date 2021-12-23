package com.supplyon.todo.service.to;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class TodoItemTO {

    @Null(message = "Id is read only")
    private Long id;

    @NotNull(message = "Task name must not be null")
    private String taskName;

    private Boolean done;
}
