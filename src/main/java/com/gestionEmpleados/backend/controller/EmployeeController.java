package com.gestionEmpleados.backend.controller;

import com.gestionEmpleados.backend.exceptions.ResourceNotFoundException;
import com.gestionEmpleados.backend.model.Employee;
import com.gestionEmpleados.backend.repository.EmpleadoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //definimos que esta clase va a ser un controlador
@RequestMapping("api/v1/") //ruta base del controlador
@CrossOrigin(origins = "http://localhost:4200") //esta notacion nos permite intercambiar recursos entre backend y frontend
public class EmployeeController {
    @Autowired
    private EmpleadoRepository repository;

    //metodo para devolver todos los empleados
    @GetMapping("/employees")
    public List<Employee> listAllEmployee(){ //devuelve una lista de la clase Employee
        return repository.findAll();
    }

    //Metodo para guardar un empleado
    @PostMapping("/employees")
    public Employee setEmployee(@RequestBody Employee employee){ //el requestbody sirve para recibir el objeto employee de tipo Employee en formato json
        return repository.save(employee);
    }

    //Metodo para buscar un empleado por su id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){ //el ResponseEntity nos devuelve un Employee
        //Definimos un employee de tipo Employee , el employee es el resultado de la funcion llamada que es finById
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id : " +id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee detailEmployee){
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id : " +id));
        employee.setName(detailEmployee.getName());//llamo la funcion setName para que setee el nombre obtenido del name de detailEmployee creado de Employee
        employee.setLastName(detailEmployee.getLastName());
        employee.setEmail(detailEmployee.getEmail());

        Employee updatedEmployee = repository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
