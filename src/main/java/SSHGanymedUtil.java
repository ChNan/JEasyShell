
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * ganymed ssh工具类 author:pengzhiyuan Created on:2016/8/29.
 */
public class SSHGanymedUtil {

	// 目标主机地址
	private String host;
	// 端口
	private int port;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 连接
	private Connection connection;

	public SSHGanymedUtil(String _host, int _port, String _userName, String _password) {
		this.host = _host;
		this.port = _port;
		this.userName = _userName;
		this.password = _password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * 登录服务器
	 * 
	 * @return
	 */
	public boolean login() {

		// 建立连接
		connection = new Connection(host, port);
		try {
			// 连接上
			connection.connect();
			// 进行校验
			boolean isAuthenticated = connection.authenticateWithPassword(userName, password);

			if (isAuthenticated) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	/**
	 * 执行shell命令
	 * 
	 * @param command
	 * @return 执行结果
	 */
	public String execCommand(final String command) throws RuntimeException {
		// 连接的通道
		Session sess = null;
		String result = "";
		try {
			// 创建session
			sess = connection.openSession();
			// // 开启远程的客户端
			// sess.requestPTY("vt100", 80, 24, 640, 480, null);
			// // 开启后睡眠4秒
			// Thread.sleep(4000);
			// 开启终端
			// 执行命令
			sess.execCommand(command);

			String errorResult = "";

			result = processOutputStream(sess.getStdout());

			Integer exitStatus = sess.getExitStatus();
			if (exitStatus != null && exitStatus != 0) {
				errorResult = processOutputStream(sess.getStderr());
			}

		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭通道
			if (sess != null) {
				sess.close();
			}
		}
		return result;
	}

	/**
	 * 处理执行结果返回信息
	 * 
	 * @param in
	 * @return
	 */
	public static String processOutputStream(InputStream in) throws IOException {
		final StringBuilder sb = new StringBuilder(256);
		// 起始时间,避免连通性陷入死循环
		long start = System.currentTimeMillis();

		InputStream stdout = new StreamGobbler(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
		// char[] arr = new char[512];
		int read;
		int i = 0;
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				// 超过5秒就退出
				// if ((System.currentTimeMillis() - start) > 5000) {
				// break;
				// }
				sb.append(line + "\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 关闭ssh连接
	 */
	public void closeConnection() {
		if (connection != null) {
			connection.close();
		}
	}

	public static void main(String[] args) {
		SSHGanymedUtil util = new SSHGanymedUtil("10.86.0.48", 22, "root", "ucsoftware");

		if (util.login()) {
			String result = null;
			try {
				result = util.execCommand("df /usr/local/" + CommonUtil.string2UnicodeNumber("测试"));
				System.out.println(result);
				String[] rltArr = result.split(" ");
				String version = "";
				for (int i = 0; i < rltArr.length; i++) {
					if (rltArr[i].equalsIgnoreCase("release")) {
						version = rltArr[i + 1];
						break;
					}
				}
				System.out.println(version);
			} catch (Exception e) {
			}
			util.closeConnection();
		}
		System.out.println();
	}
}
