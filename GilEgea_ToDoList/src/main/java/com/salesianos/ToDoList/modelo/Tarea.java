package com.salesianos.ToDoList.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaCaducidad;

}
