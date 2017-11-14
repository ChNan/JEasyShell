/**
 * @author CHNan
 * @date 2017/11/14
 */
public class Option {

    private String option;

    private String description;


    public Option(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public Option setOption(String option) {
        this.option = option;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Option setDescription(String description) {
        this.description = description;
        return this;
    }
}
