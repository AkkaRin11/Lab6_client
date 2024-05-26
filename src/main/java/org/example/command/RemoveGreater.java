package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class RemoveGreater extends Command{
    private final ObjectController objectController;
    public RemoveGreater(){
        objectController = new ObjectController();
        argSize = 0;
        name = "remove_greater";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        LabWork labWork = objectController.getLabWorkObj();

        return new CommandRequest(name, args, null);
    }
}
