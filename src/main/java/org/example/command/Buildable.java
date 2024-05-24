package org.example.command;

import org.example.Dto.CommandRequest;

public interface Buildable {
    CommandRequest build(String... args);
}
