package org.example.command;

import org.example.Dto.CommandRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExecuteScript extends Command{

    public ExecuteScript(){
        argSize = 1;
        name = "execute_script";
    }

    @Override
    public CommandRequest build(String... args) {
        if (!isSizeCorrect(args.length)) {
            return null;
        }

        List<String> commands = new ArrayList<>();
        readFile(args[0], commands);

        if (commands.isEmpty()){
            return null;
        }

        return new CommandRequest(name, args, (Serializable) commands);
    }

    private void readFile(String fileName, List<String>  answer){

        Scanner sc;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            return;
        }

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] str = line.replaceAll("\n", "").split("\\s+");

            if (str[0].equals("execute_script") && str.length == 2){
                readFile(str[1], answer);
            } else {
                answer.add(line);
            }
        }
    }
}
