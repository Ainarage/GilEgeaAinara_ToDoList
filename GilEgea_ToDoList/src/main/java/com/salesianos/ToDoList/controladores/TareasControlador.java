package com.salesianos.ToDoList.controladores;


import com.salesianos.ToDoList.modelo.Tarea;
import com.salesianos.ToDoList.servicios.TareaServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/tarea")

public class TareasControlador {

    private final TareaServicio tareaServicio;

    @GetMapping("/")
    public String list (Model model){
        model.addAttribute("lista", tareaServicio.todasLasTareasPorOrdenDeCaducidad());
        return "tarea/index";
    }

    @GetMapping("/nuevaTarea")
    public String crearTarea(Model model){
        model.addAttribute("tarea", new Tarea());
        return "tarea/formulario";
    }

    @PostMapping("/submit")
    public String submitNuevaTarea(
            @ModelAttribute("tarea") Tarea tarea){
        tareaServicio.save(tarea);
        return "redirect:/tarea/";
    }


  /*EDITAR DESCRIPCION*/
    @GetMapping("editarTarea/{id}")
    public String editarTarea(@PathVariable("id")long id, Model model){
        Tarea tEditar = tareaServicio.findById(id);
        model.addAttribute("tarea", tareaServicio.findAll());
        if(tEditar != null){
            model.addAttribute("descripcion", tEditar);
            return "tarea/formDescripcion";

        }else{
            return "redirect:/tarea/";
        }

        @PostMapping("/editarTarea/submit")
                public String enviarFormEditarDescripcion(@ModelAttribute("tarea") Tarea t) {
                    tareaServicio.edit(t);
                    return "redirect:/tarea/descripcion";
        }
    }
}
