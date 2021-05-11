package com.userservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document
@Data
public class User extends BaseMongoModel {
    private String lastName;
    private String firstName;
    private String otherName;
    private String dob;
    private List<Interest> interests;
}
