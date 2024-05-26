package org.example.command;

import org.example.Dto.CommandRequest;
import org.example.controller.ObjectController;
import org.example.model.LabWork;

public class FilterContainsName extends Command{
    public FilterContainsName(){
        argSize = 1;
        name = "filter_contains_name";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
