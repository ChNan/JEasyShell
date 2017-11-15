/**
 * @author CHNan
 * @date 2017/11/14
 */
public class Test {

    public static void main(String[] args) {
        // mkdir().destFile("/usr/local/test.txt").execute();

        Shell2 shell = new Shell2();

        shell.mkdir().destFile(new DestFile("/usr/local","1.txt")).append();
    }
}
