package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.views.UserNameCountTodos;

import java.util.List;

public interface TodosService
{
    void markComplete(long todoid);
    Todo findById(long id);
    List<UserNameCountTodos> findTodoCounts();
}
