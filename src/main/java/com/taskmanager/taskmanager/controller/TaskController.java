package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.entities.TaskEntity;
import com.taskmanager.taskmanager.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Slf4j
@RequestMapping(value = "api/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ResponseEntity<?> getTasks(){
        log.info("get tasks service");
        List<TaskEntity> tasks = taskService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id){
        Map<String, Object> mensajes = new HashMap<>();
        TaskEntity task = null;
		try {
            task = taskService.getTaskById(id);
			if (task == null) {
				mensajes.put("mensaje", "No se encontró la tarea con id:".concat(id.toString()));
				return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.NOT_FOUND);
			}
		}catch (DataAccessException e){
			mensajes.put("mensaje", "Ocurrió un error al consultar la tarea con id: ".concat(id.toString()));
			mensajes.put("mensaje", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> setTask(@RequestBody TaskEntity task){
        Map<String, Object> mensajes = new HashMap<>();
        TaskEntity taskNew = null;
		try {
			taskNew = this.taskService.setTask(task);;
			mensajes.put("Info", "Tarea creada correctamente");
			mensajes.put("tarea", taskNew);
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.CREATED);
		}catch (DataAccessException e){
			mensajes.put("mensaje", "Ocurrio un error al insertar en la base de datos");
			mensajes.put("Error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}


    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@RequestBody TaskEntity task, @PathVariable Long id){
        Map<String, Object> mensajes = new HashMap<>();
        task.setId(id);
		TaskEntity nuevaTarea = null;
		try {
			nuevaTarea = this.taskService.updateTask(task);
			mensajes.put("Info", "Tarea actualizada correctamente");
			mensajes.put("tarea", nuevaTarea);
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.CREATED);
		}catch (DataAccessException e){
			mensajes.put("mensaje", "Ocurrio un error al insertar en la base de datos");
			mensajes.put("Error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){

        Map<String, Object> mensajes = new HashMap<>();
		try {
            this.taskService.deleteTask(id);
			mensajes.put("mensaje", "Se eliminó correctamente");
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.OK);
		}catch (DataAccessException e){
			mensajes.put("mensaje", "Ocurrio un error al eliminar de la base de datos");
			mensajes.put("Error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
