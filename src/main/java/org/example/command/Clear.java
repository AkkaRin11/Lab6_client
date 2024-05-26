package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class Clear extends Command{
    public Clear(){
        argSize = 0;
        name = "clear";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args);
    }
}
