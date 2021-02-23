package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.views.UserNameCountTodos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long>
{
    @Query(value = "SELECT  u.username, count(id) AS counttodos FROM users u LEFT JOIN todo t ON t.userid = u.userid WHERE t.completed = false GROUP BY u.username ORDER BY u.username DESC", nativeQuery = true)
    List<UserNameCountTodos> findTodoCounts();
}