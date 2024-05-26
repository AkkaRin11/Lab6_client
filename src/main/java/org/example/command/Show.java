package org.example.command;

import org.example.Dto.CommandRequest;

public class Show extends Command{
    public Show(){
        argSize = 0;
        name = "show";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
