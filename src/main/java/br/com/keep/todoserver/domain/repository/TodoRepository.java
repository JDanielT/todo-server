package br.com.keep.todoserver.domain.repository;

import br.com.keep.todoserver.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
