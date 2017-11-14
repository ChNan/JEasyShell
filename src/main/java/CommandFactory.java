/**
 * @author CHNan
 * @date 2017/11/14
 */
public class CommandFactory {

    static class Ls extends AbstractCommand {

        public String to() {
            return "ls";
        }
    }

    static class Mkdir extends AbstractCommand {

        public String to() {
            return "mkdir";
        }

        private DestFile destFile;

        public Mkdir destFile(DestFile destFile) {
            this.destFile = destFile;
            return this;
        }
    }

    static class LL extends AbstractCommand {

        public String to() {
            return null;
        }
    }

    static class Cd extends AbstractCommand {

        public String to() {
            return null;
        }
    }


    static class Grep extends AbstractCommand {


        public String to() {
            return null;
        }
    }

    static class More extends AbstractCommand {

        public String to() {
            return null;
        }
    }


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
