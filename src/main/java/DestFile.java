import java.io.File;

/**
 * @author CHNan
 * @date 2017/11/14
 */
public class DestFile {

    private String filePath;

    private String fileName;

    public DestFile(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public DestFile setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public DestFile setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String build(){
        return filePath+ File.pathSeparator+fileName;
    }
}
