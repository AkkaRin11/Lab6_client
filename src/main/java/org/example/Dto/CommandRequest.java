package org.example.Dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CommandRequest implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String commandName;
    private String commandStringArgument;
    private Serializable commandObjectArgument;

    public CommandRequest(String commandName, String commandStringArgument, Serializable commandObjectArgument) {
        this.commandName = commandName;
        this.commandStringArgument = commandStringArgument;
        this.commandObjectArgument = commandObjectArgument;
    }

    public CommandRequest(String commandName, String commandStringArgument) {
        this.commandName = commandName;
        this.commandStringArgument = commandStringArgument;
        this.commandObjectArgument = null;
    }
}
