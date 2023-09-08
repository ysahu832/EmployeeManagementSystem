package com.genpact.main;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.genpact.main.controllers.EmployeeController;
import com.genpact.main.entity.Employee;
import com.genpact.main.service.EmployeeService;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @Mock
    private Model model;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "john.doe@example.com", null, null, null, null, null, null, null));
        employees.add(new Employee(2, "Jane Smith", "jane.smith@example.com", null, null, null, null, null, null, null));

        when(employeeService.findAll()).thenReturn(employees);

        String viewName = employeeController.listEmployees(model);

        verify(employeeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("employees"), eq(employees));
        
    }

    @Test
    void testViewEmployeeDetails() {
        int employeeId = 1;
        Employee employee = new Employee(employeeId, "John Doe", "john.doe@example.com", null, null, null, null, null, null, null);

        when(employeeService.findById(employeeId)).thenReturn(employee);

        String viewName = employeeController.viewEmploye(employeeId, model);

        verify(employeeService, times(1)).findById(employeeId);
        verify(model, times(1)).addAttribute(eq("employee"), eq(employee));
      
    }

}

