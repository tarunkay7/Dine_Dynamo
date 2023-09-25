package com.project.dinedynamo.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class User {

    private String name;
    private String rollNumber;
    private String phoneNumber;
    private boolean isAdmin;

}
