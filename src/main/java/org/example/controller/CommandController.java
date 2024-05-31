package org.example.controller;

import lombok.Getter;
import org.example.Dto.CommandRequest;
import org.example.command.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * Класс для управления командами
 *
 */

public class CommandController {
    @Getter
    private static Map<String, Command> commands;

    static {
        commands = new LinkedHashMap<>();

        commands.put("add", new Add());
        commands.put("update", new Update());
        commands.put("add_if_max", new AddIfMax());
        commands.put("clear", new Clear());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("filter_contains_name", new FilterContainsName());
        commands.put("filter_greater_than_minimal_point", new FilterGreaterThanMinimalPoint());
        commands.put("help", new Help());
        commands.put("history", new History());
        commands.put("info", new Info());
        commands.put("remove_by_id", new RemoveById());
        commands.put("remove_greater", new RemoveGreater());
        commands.put("show", new Show());
        commands.put("sum_of_average_point", new SumOfAveragePoint());
        commands.put("save", new Save());
    }

    public CommandRequest buildCommand(String commandName, String... args) {
        Command command = getCommandByName(commandName);
        CommandRequest commandRequest = command.build(args);

        return commandRequest;
    }

    public static boolean isValidCommand(String input) {
        return commands.get(input) != null;
    }

    public static Command getCommandByName(String commandName) {
        return commands.get(commandName);
    }

}
