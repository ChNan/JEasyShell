import java.util.List;

/**
 * @author CHNan
 * @date 2017/11/14
 */
public class CommandList implements Command, Shell {

    // 命令工厂
    private CommandFactory commandFactory;

    protected List<Command> commands;

    public CommandList mkdir(){
        return add(commandFactory.mkdir());
    }


    private CommandList add(Command command) {

        commands.add(command);

        return this;
    }

    public String parse() {

        if (commands == null || commands.isEmpty()) {
            return null;
        }

        if (commands.size() == 1) {
            return commands.get(0).parse();
        }

        String result = null;

        for (int i = 1; i < commands.size(); i++) {

            if (i == 1) {
                result = mergeConditions(noNullExpressionList.get(0).convert(), noNullExpressionList.get(1));
                continue;
            }

            result = mergeConditions(result, noNullExpressionList.get(i));
        }

        return result;
    }

    public void execute() {

    }
}
