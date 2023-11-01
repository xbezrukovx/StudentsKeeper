package com.example.studentsKeeper.event;

import com.example.studentsKeeper.StudentModel;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventHolder extends ApplicationEvent {
    private final StudentModel studentModel;
    private final EventType eventType;
    public EventHolder(Object source, StudentModel studentModel, EventType eventType) {
        super(source);
        this.eventType = eventType;
        this.studentModel = studentModel;
    }
}
