package com.example.studentsKeeper;

import com.example.studentsKeeper.event.EventHolder;
import com.example.studentsKeeper.event.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import java.util.HashMap;
import java.util.UUID;

@RequiredArgsConstructor
public class StudentsKeeper {
    private final HashMap<UUID, StudentModel> students = new HashMap<>();
    private final ApplicationEventPublisher publisher;

    public void add(String firstName, String lastName, int age) {
        UUID id = UUID.randomUUID();
        StudentModel student = StudentModel.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .id(id)
                .build();
        students.put(id, student);
        EventHolder eventHolder = new EventHolder(this, student, EventType.ADD);
        publisher.publishEvent(eventHolder);
    }

    public void show() {
        students.forEach((i,s) -> {
            System.out.println(s);
        });
    }

    public void remove(UUID id){
        StudentModel studentModel = students.remove(id);
        EventHolder eventHolder = new EventHolder(this, studentModel, EventType.REMOVE);
        publisher.publishEvent(eventHolder);
    }

    public void removeAll() {
        students.clear();
        EventHolder eventHolder = new EventHolder(this, null, EventType.REMOVE_ALL);
        publisher.publishEvent(eventHolder);
    }
}
