package org.example.command;

import org.example.Dto.CommandRequest;

public class History extends Command{
    public History(){
        argSize = 0;
        name = "history";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
