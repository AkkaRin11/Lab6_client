package org.example.command;

import org.example.Dto.CommandRequest;

public class RemoveById extends Command{
    public RemoveById(){
        argSize = 1;
        name = "remove_by_id";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
