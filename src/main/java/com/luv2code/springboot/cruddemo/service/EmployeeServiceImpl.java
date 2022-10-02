package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }


    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeDAO.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }

}






