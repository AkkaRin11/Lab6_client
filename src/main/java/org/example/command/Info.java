package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class Info extends Command{
    public final ObjectController objectController;

    public Info(){
        objectController = new ObjectController();
        argSize = 0;
        name = "info";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args);
    }
}
