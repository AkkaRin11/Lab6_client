package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class Add extends Command{
    private final ObjectController objectController;

    public Add(){
        objectController = new ObjectController();
        argSize = 0;
        name = "add";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        LabWork labWork = objectController.getLabWorkObj();

        return new CommandRequest(name, args, labWork);
    }
}
