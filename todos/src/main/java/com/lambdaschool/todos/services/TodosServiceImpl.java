package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.views.UserNameCountTodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodoRepository todoRepository;
    @Transactional
    @Override
    public void markComplete(long todoid) {
        Todo completedtodo = todoRepository.findById(todoid)
                .orElseThrow(()-> new EntityNotFoundException("Todo " + todoid + " not found"));
        completedtodo.setCompleted(true);
    }

    @Override
    public Todo findById(long id) {
        Todo myTodo =todoRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Todo " + id + " not found"));
        return myTodo;
    }

    @Override
    public List<UserNameCountTodos> findTodoCounts() {
        List<UserNameCountTodos> myList = new ArrayList<>();
        todoRepository.findTodoCounts().iterator().forEachRemaining(myList::add);
        return myList;
    }
}
