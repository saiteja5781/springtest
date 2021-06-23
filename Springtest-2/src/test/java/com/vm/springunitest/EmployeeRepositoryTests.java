package com.vm.springunitest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {

        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testGetEmployee() {

        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        employeeRepository.delete(employee);
    }

    @Test
    public void findAllEmployees() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        assertNotNull(employeeRepository.findAll());
    }

    @Test
    public void deletByEmployeeIdTest() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        Employee emp = employeeRepository.save(employee);
        employeeRepository.deleteById(emp.getId());
    }
}