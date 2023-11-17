/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academiasofttek.actividadM5.service;

import com.academiasofttek.actividadM5.entity.Task;
import com.academiasofttek.actividadM5.interfaceService.TaskService;
import com.academiasofttek.actividadM5.interfaces.ITask;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Martin Gimenez
 */

@Service
public class TaskServiceImpl implements TaskService {

    //inyeccion de la clase ITask
    @Autowired
    private ITask itask;
    
    // Metodos para interactuar con la base de datos

    @Override
    public List<Task> getAllTasks() {
        return itask.findAll();
    }

    @Override
    public Task getTaskById(int taskId) {
        Optional <Task> task = itask.findById(taskId);
        return task.orElse(null);
        }

    @Override
    public Task createTask(Task task) {
        return itask.save(task);
        }

    @Override
    public Task updateTask(int taskId, Task taskDetails) {
        var optionalTask = itask.findById(taskId);
         if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(taskDetails.getTitle());
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setStatus(taskDetails.getStatus());
            return itask.save(existingTask);
        }
        return null;
        
          }

    @Override
    public void deleteTask(int taskId) {
         itask.deleteById(taskId);
         }

}



