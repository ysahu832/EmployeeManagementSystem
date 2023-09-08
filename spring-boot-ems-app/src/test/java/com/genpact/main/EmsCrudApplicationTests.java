package com.genpact.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.genpact.main.controllers.EmployeeController;

@SpringBootTest
public class EmsCrudApplicationTests {

    @MockBean
    private EmployeeController employeeController;

    @SpyBean
    private EmsCrudApplication emsCrudApplication;

    @Test
    public void contextLoads() {
        // Testing  the application context loads successfully working
    }

    @Test
    public void mainTest() {
        // Tests the main method of EmsCrudApplication
        EmsCrudApplication.main(new String[]{});
    }


}
