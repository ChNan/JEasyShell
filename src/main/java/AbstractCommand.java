import java.util.ArrayList;
import java.util.List;

/**
 * @author CHNan
 * @date 2017/11/14
 */
public abstract class AbstractCommand implements Command {

    protected String command;

    public AbstractCommand(final String command) {
        this.command = command;
    }

    private List<Option> options = new ArrayList<Option>();

    private SourceFile sourceFile;

    public void addOption(Option option) {

        options.add(option);
    }

}
