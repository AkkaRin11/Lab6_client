package org.example.command;

import org.example.Dto.CommandRequest;

public class Help extends Command{
    public Help(){
        argSize = 0;
        name = "help";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
