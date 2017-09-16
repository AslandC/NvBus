package log;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.net.SocketAppender;
import org.apache.log4j.xml.DOMConfigurator;

public class Test {
	public static void main(String[] args) {
		
//		DOMConfigurator.configure(Test.class.getResource("../conf/log4j.properties"));
//		DOMConfigurator.configure("G:/SVN2/bj_1404_zw/branches/NvBus/5.12/server/Test/conf/log4j.properties");
//		DOMConfigurator.con
//		Logger log = LogManager.getLogger("testRemote");
		
		// Logger log = Logger.getRootLogger();
//		log.info("This is a log !");
		
		new Test().log();
	}
	
	public void log(){
		Logger log = Logger.getLogger(Test.class);
//		BasicConfigurator.configure ();// 自动快速地使用缺省 Log4j 环境。 
		PropertyConfigurator.configure("G:/SVN2/bj_1404_zw/branches/NvBus/5.12/server/Test/conf/log4j.properties");//读取使用 Java 的特性文件编写的配置文件。 
//		DOMConfigurator.configure ( String filename );//读取 XML 形式的配置文件。 
		log.info( "zzzzz") ;
	}
}
