package br.com.keep.todoserver.domain.service;

import br.com.keep.todoserver.domain.model.Todo;
import br.com.keep.todoserver.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

}
