package br.com.keep.todoserver.application.controller;

import br.com.keep.todoserver.domain.model.Todo;
import br.com.keep.todoserver.domain.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoService.save(todo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {
        var todo = todoService.findById(id).orElse(null);
        if(todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        var todo = todoService.findById(id);
        if(todo == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .build();
        }
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

}
