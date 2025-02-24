package com.chandra.MUIBackendAPI.service;

import com.chandra.MUIBackendAPI.models.ApiResponse;
import com.chandra.MUIBackendAPI.models.Employee;
import com.chandra.MUIBackendAPI.models.EmployeeFormModel;
import com.chandra.MUIBackendAPI.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ApiResponse<Employee> saveEmployee(EmployeeFormModel employeeFormModel) {
        // Validate input
        if (isMissingRequiredFields(employeeFormModel)) {
            return new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Failed to save employee: Missing required fields",
                    null
            );
        }

        // Convert EmployeeFormModel to Employee entity and save to database
        Employee savedEmployee = employeeRepository.save(convertToEntity(employeeFormModel));

        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Employee saved successfully",
                savedEmployee
        );
    }
    private Employee convertToEntity(EmployeeFormModel formModel) {
        return Employee.builder()
                .firstName(formModel.getFirstName())
                .lastName(formModel.getLastName())
                .email(formModel.getEmail())
                .phone(formModel.getPhone())
                .dateOfJoining(formModel.getDateOfJoining())
                .countryCode(formModel.getCountry())
                .address(formModel.getAddress())
                .build();
    }
    private boolean isMissingRequiredFields(EmployeeFormModel employeeFormModel) {
        return Stream.of(employeeFormModel.getFirstName(),
                        employeeFormModel.getLastName(),
                        employeeFormModel.getEmail())
                .anyMatch(field -> field == null || field.isBlank());
    }

    public ApiResponse<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (!employees.isEmpty()) {
            return new ApiResponse<>(HttpStatus.OK.value(), "Employees retrieved successfully", employees);
        } else {
            return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "No employees found", null);
        }
    }
}
