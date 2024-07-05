package com.example.model;

import lombok.Data;
import java.time.LocalDate;
@Data
public class Customer {

    public Customer(String firstName, boolean  isEmployee, boolean affiliatedToStore, LocalDate createdDate) {
        this.firstName = firstName;
        this.isEmployee = isEmployee;
        this.affiliatedToStore = affiliatedToStore;
        this.createdDate = createdDate;
    }
    private String firstName;

    private boolean isEmployee;

    private boolean affiliatedToStore;

    private LocalDate createdDate;

}
