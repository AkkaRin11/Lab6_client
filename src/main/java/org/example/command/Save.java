package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class Save extends Command{
    public Save(){
        argSize = 0;
        name = "save";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }



        return new CommandRequest(name, args);
    }
}
