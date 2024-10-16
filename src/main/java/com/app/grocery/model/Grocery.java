package com.app.grocery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("grocery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Grocery {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;

}
