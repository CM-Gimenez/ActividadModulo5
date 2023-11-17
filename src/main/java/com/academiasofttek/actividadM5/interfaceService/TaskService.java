/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.academiasofttek.actividadM5.interfaceService;

import com.academiasofttek.actividadM5.entity.Task;
import java.util.List;

/**
 *
 * @author Carlos Martin Gimenez
 */

    public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(int taskId);
    Task createTask(Task task);
    Task updateTask(int taskId, Task taskDetails);
    void deleteTask(int taskId);
}

    

