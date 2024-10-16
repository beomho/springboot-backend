package com.app.employee.repository;

import com.app.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    @Query("{id:'?0'}")
    Employee findItemById(String id);
    
    @Query("{name:'?0'}")
    Employee findItemByName(String name);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<Employee> findAll(String category);

    public long count();

}
