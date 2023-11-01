package com.example.studentsKeeper.config.analyzer;

import com.example.studentsKeeper.exception.StudentsKeeperPropertyException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

import java.text.MessageFormat;

public class StudentsKeeperPropertyFailureAnalyzer extends AbstractFailureAnalyzer<StudentsKeeperPropertyException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, StudentsKeeperPropertyException cause) {
        return new FailureAnalysis(MessageFormat.format("Exception when try to  set property: {0}", cause.getMessage()),
                "set-application-properties", cause);
    }
}
