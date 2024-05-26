package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class Update extends Command{
    public final ObjectController objectController;

    public Update(){
        objectController = new ObjectController();
        argSize = 1;
        name = "update";
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
