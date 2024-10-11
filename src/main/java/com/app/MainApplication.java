package com.app;

import com.app.model.GroceryItem;
import com.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
@EnableMongoRepositories
public class MainApplication implements CommandLineRunner {

   @Autowired
   ItemRepository groceryItemRepo;

   public static void main(String[] args) {
      SpringApplication.run(MainApplication.class, args);
   }

   @Override
   public void run(String... args) throws Exception {
      log.info("-------------CREATE GROCERY ITEMS------\n");
      createGroceryItems();

      log.info("\n------------SHOW ALL GROCERY ITEMS---\n");
      showAllGroceryItems();
   }

   void createGroceryItems() {
      log.info("Data creation started...");
      groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
      log.info("Data creation complete...");
   }

   public void showAllGroceryItems() {
      groceryItemRepo.findAll().forEach(item -> log.info(getItemDetails(item)));
   }

   public void getGroceryItemByName(String name) {
      log.info("Getting item by name: " + name);
      GroceryItem item = groceryItemRepo.findItemByName(name);
      log.info(getItemDetails(item));
   }

   public String getItemDetails(GroceryItem item) {
      log.info("Item Name: " + item.getName() + ", \nQuantity: " + item.getQuantity() + ", \nItem Category: " + item.getCategory());
      return "";
   }
   
}
