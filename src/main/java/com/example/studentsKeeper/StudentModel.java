package com.example.studentsKeeper;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StudentModel {
    private final UUID id;
    private String firstName;
    private String lastName;
    private int age;
}
