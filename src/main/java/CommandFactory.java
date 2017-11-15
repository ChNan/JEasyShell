/**
 * @author CHNan
 * @date 2017/11/14
 */
public class CommandFactory {

    static class Ls extends AbstractCommand {


        public Ls() {
            super("ls");
        }
        public String parse() {
            return "ls";
        }
    }

    static class Mkdir extends AbstractCommand {

        public Mkdir() {
            super("mkdir");
        }

        public String parse() {
            return command+" "+destFile.build();
        }

        private DestFile destFile;

        public Mkdir destFile(DestFile destFile) {
            this.destFile = destFile;
            return this;
        }
    }


    // ============================== 返回Command实例 ==============================

    public Command mkdir() {

        return new Mkdir();
    }
//
//    static class LL extends AbstractCommand {
//
//        public String append() {
//            return null;
//        }
//    }
//
//    static class Cd extends AbstractCommand {
//
//        public String append() {
//            return null;
//        }
//    }
//
//
//    static class Grep extends AbstractCommand {
//
//
//        public String append() {
//            return null;
//        }
//    }
//
//    static class More extends AbstractCommand {
//
//        public String append() {
//            return null;
//        }
//    }


    /************************************************************************************************************************/
    /************************************************************************************************************************/
    /******************************************************系统管理命令*******************************************************/
    /************************************************************************************************************************/
    /************************************************************************************************************************/
    static class Stat {

    }

    static class Who {

    }

    static class Whoami {

    }

    static class Hostname {

    }

    static class Uname {

    }

    static class Top {

    }

    static class Ps {

    }

    static class Du {

    }

    static class Df {

    }

    static class Ifconfig {

    }

    static class Ping {

    }

    static class Netstat {

    }

    static class Man {

    }

    static class Clear {

    }

    static class Alias {

    }

    static class Kill {

    }


    /*****************************************************打包压缩相关命令******************************************************/

    static class Gzip {

    }

    static class Bzip2 {

    }

    static class Tar {

    }
}
