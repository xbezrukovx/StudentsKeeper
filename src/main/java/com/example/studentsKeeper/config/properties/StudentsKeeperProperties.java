package com.example.studentsKeeper.config.properties;

import com.example.studentsKeeper.config.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "students-keeper")
@Getter
@Setter
public class StudentsKeeperProperties {
    private Boolean loadOnStart;
    private List<Student> students;
}
