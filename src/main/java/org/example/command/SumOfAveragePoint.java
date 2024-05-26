package org.example.command;

import org.example.Dto.CommandRequest;

public class SumOfAveragePoint extends Command{
    public SumOfAveragePoint(){
        argSize = 0;
        name = "sum_of_average_point";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        return new CommandRequest(name, args, null);
    }
}
