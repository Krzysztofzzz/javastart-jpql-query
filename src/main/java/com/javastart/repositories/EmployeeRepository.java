package com.javastart.repositories;

import com.javastart.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT e FROM Employee e WHERE e.salary>10000")
    List<Employee> findRichEmployees();

    @Query(value = "UPDATE Employee e SET e.salary = e.salary+100")
    @Modifying
    @Transactional
    void giveRiseToAll();

    @Query(value = "SELECT e FROM Employee e WHERE e.salary>:min AND e.salary<:max")
    List<Employee> findBySalaryInRange(double min, double max);
}
