package com.salesianos.ToDoList.repositorios;

import com.salesianos.ToDoList.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
}
