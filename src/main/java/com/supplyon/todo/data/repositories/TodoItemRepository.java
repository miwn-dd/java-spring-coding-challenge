package com.supplyon.todo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplyon.todo.data.models.TodoItem;

@Repository("TodoItemRepository")
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
