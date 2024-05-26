package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class AddIfMax extends Command{
    private final ObjectController objectController;

    public AddIfMax(){
        objectController = new ObjectController();
        argSize = 0;
        name = "add_if_max";
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
