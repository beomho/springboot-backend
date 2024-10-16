package com.app.grocery.repository;

import com.app.grocery.model.Grocery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GroceryRepository extends MongoRepository<Grocery, String> {

    @Query("{id:'?0'}")
    Grocery findItemById(String id);
    
    @Query("{name:'?0'}")
    Grocery findItemByName(String name);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<Grocery> findAll(String category);

    public long count();

}
