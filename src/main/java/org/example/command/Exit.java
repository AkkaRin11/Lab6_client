package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

import static java.lang.System.exit;

public class Exit extends Command{
    public Exit(){
        argSize = 0;
        name = "exit";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        exit(1);

        return new CommandRequest(name, args, null);
    }
}
