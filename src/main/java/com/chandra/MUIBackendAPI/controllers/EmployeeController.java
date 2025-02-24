package com.chandra.MUIBackendAPI.controllers;

import com.chandra.MUIBackendAPI.models.ApiResponse;
import com.chandra.MUIBackendAPI.models.Employee;
import com.chandra.MUIBackendAPI.models.EmployeeFormModel;
import com.chandra.MUIBackendAPI.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to access API
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Save Employee
    @PostMapping(value = "/saveEmployee", produces = "application/json")
    public ResponseEntity<ApiResponse<Employee>> saveEmployee(@RequestBody EmployeeFormModel employeeFormModel) {
        ApiResponse<Employee> response = employeeService.saveEmployee(employeeFormModel);

        // Check response status and return accordingly
        if (response.getStatusCode() == HttpStatus.CREATED.value()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // Fetch All Employees
    @GetMapping(value = "/findAllEmployees", produces = "application/json")
    public ResponseEntity<ApiResponse<List<Employee>>> findAllEmployees() {
        ApiResponse<List<Employee>> response = employeeService.getAllEmployees();

        if (response.getStatusCode() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
    }
}
