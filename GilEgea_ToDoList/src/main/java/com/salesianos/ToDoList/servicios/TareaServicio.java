package com.salesianos.ToDoList.servicios;

import com.salesianos.ToDoList.modelo.Tarea;
import com.salesianos.ToDoList.repositorios.TareaRepositorio;
import com.salesianos.ToDoList.servicios.Base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaServicio extends ServicioBaseImpl<Tarea, Long, TareaRepositorio> {

  public List<Tarea> todasLasTareasPorOrdenDeCaducidad(){
        return this.findAll().stream()
                .map(p -> {
                   p.getNombre();
                   return p;
                }).collect(Collectors.toList());
    }
}
