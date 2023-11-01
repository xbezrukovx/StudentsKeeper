package com.example.studentsKeeper.config;

import com.example.studentsKeeper.StudentsKeeper;
import com.example.studentsKeeper.config.properties.StudentsKeeperProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(StudentsKeeperProperties.class)
public class StudentsKeeperConfiguration {
    @Bean
    public StudentsKeeper studentsKeeper(ApplicationEventPublisher publisher, StudentsKeeperProperties properties) {
        StudentsKeeper studentsKeeper = new StudentsKeeper(publisher);
        if (properties.getLoadOnStart() && properties.getStudents() != null) {
            List<Student> studentList = properties.getStudents();
            studentList.forEach(s ->
                studentsKeeper.add(
                        s.getFirstName(),
                        s.getLastName(),
                        s.getAge()
                )
            );
        }
        studentsKeeper.show();
        return studentsKeeper;
    }
}
