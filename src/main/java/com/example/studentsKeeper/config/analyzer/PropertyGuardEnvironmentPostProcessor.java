package com.example.studentsKeeper.config.analyzer;

import com.example.studentsKeeper.exception.StudentsKeeperPropertyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class PropertyGuardEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Boolean loadOnStart = Boolean.parseBoolean(environment.getProperty("students-keeper.loadOnStart"));
        if (loadOnStart == null) throw new StudentsKeeperPropertyException("Property students-keeper.loadOnStart must be filled!");
    }
}
