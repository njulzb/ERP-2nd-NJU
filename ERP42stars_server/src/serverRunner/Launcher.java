package serverRunner;

/**
 * server 程序入口
 * @author LZB
 *
 */
public class Launcher {
	public static void main (String args[]){
		Launcher launcher = new Launcher();
		launcher.initServer();
	}
	
	/**
	 * 初始化rmi ，注册服务
	 */
	private void initServer(){
		new ServerRunner();
	}
}	
