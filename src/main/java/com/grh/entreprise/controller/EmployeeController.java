package com.grh.entreprise.controller;

import com.grh.entreprise.model.Employee;
import com.grh.entreprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
/*@CrossOrigin(origins = "http://localhost:4200")*/

public class EmployeeController {

        private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }
        @GetMapping("/all")
        public ResponseEntity<List<Employee>> getAllEmployees () {
            List<Employee> employees = employeeService.findAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
            Employee employee = employeeService.findEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
            Employee newEmployee = employeeService.addEmployee(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
            employee.setId(id);
            Employee updateEmployee = employeeService.updateEmployee(employee);
            return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}

