package org.example.command;

import org.example.Dto.CommandRequest;

public class FilterGreaterThanMinimalPoint extends Command{
    public FilterGreaterThanMinimalPoint(){
        argSize = 1;
        name = "filter_greater_than_minimal_point";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
