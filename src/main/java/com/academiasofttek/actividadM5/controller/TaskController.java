
package com.academiasofttek.actividadM5.controller;

import com.academiasofttek.actividadM5.entity.Task;
import com.academiasofttek.actividadM5.interfaceService.TaskService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Carlos Martin Gimenez
 */
@Controller
@RequestMapping
public class TaskController {

    
    // Inyeccion de la clase TaskService
    @Autowired
    private TaskService taskService;
    
    
     @GetMapping("/")
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task()); 
        return "new"; 
    }

    @PostMapping("/save")
    public String saveTask(Task task) {
        taskService.createTask(task);
        return "redirect:/"; 
    }
    
    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "new";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") int id, Task task) {
        taskService.updateTask(id, task);
        return "redirect:/"; // Redirige a la página de lista de tareas después de actualizar
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return "redirect:/"; // Redirige a la página de lista de tareas después de eliminar
    }
    
    // Metodos HTTP para ser consumidos desde el frontend
    /*@GetMapping("/")
    public String listar(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("task", tasks);
        return "index";
    }

    //Creamos el método para agregar new
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("task", new Task());
        return "newtask";
    }
    
    @PostMapping("/save")
    public String save(@Valid Task p, Model model){
        taskService.createTask(p);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editar( Model model, @PathVariable int id) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "newtask";
    }
    
    @GetMapping("delete/{id}")
    public String delete(Model model,@PathVariable int id){
        taskService.deleteTask(id);
        return "redirect:/";
    }*/
    
    
    
}
