package Actions;



import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.WriterOutputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import org.postgresql.Driver;
import com.sun.jna.platform.win32.OaIdl.VARIANT_BOOL;

import Actions.Jenkins;
import TestSkyBuy.SkyBuy.Constants;



 
public class TestDriver
{	public static String cat = System.getProperty("user.dir");
	public static Session session =null;
	public static Session session2 =null;
	public  static  Connection con =null;
	public  static  Connection con2 =null;
	public static WebDriver driver;
	public static WebDriverWait   wait1;
	
	public static String host = new String();
	public static String port = new String();
	public static String mailFrom = new String();
	public static String password = new String();
	public static String mailTo = new String();
	public static String subject = new String();
	public static String message = new String();
	public static  String[] attachFiles = new String[1];
	public static  File newFile = new File(cat+"\\ErrorscreenShot3.png");
	
	
	public static void doSshTunnel(  ) throws JSchException{
		 try {
	            JSch jsch = new JSch();

	            String user = "ivanov";
	            String host = "62.76.25.115";
	            int port = 22;
	            String privateKey = "C:\\Users\\ivanov\\eclipse-workspace\\SkyBuy\\src\\main\\java\\Actions\\rtrt";//".ssh/id_rsa";

	            jsch.addIdentity(privateKey,"tttt");
	            System.out.println("identity added ");

	            session = jsch.getSession(user, host, port);
	            System.out.println("session created.");

	            // disabling StrictHostKeyChecking may help to make connection but makes it insecure
	            // see http://stackoverflow.com/questions/30178936/jsch-sftp-security-with-session-setconfigstricthostkeychecking-no
	            // 
	            java.util.Properties config = new java.util.Properties();
	             config.put("StrictHostKeyChecking", "no");
	            session.setConfig(config);

	            session.connect();
	        
	        } catch (Exception e) {
	            System.err.println(e);
	        }
		 System.out.println( session.getHost());
		 session.setPortForwardingL(5432, "127.0.0.1", 5432);
		 System.out.println("-------- PostgreSQL "
					+ "JDBC Connection Testing ------------");

			try {

				  Class dbDriver = Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {

				System.out.println("Where is your PostgreSQL JDBC Driver? "
						+ "Include in your library path!");
				e.printStackTrace();
				return;

			}

			System.out.println("PostgreSQL JDBC Driver Registered!");

		

			try {
				String url = "jdbc:postgresql://127.0.0.1:5432/sbf_SKYZ-"+Constants.featureName;
				//+
				//        "ssl=true&"+
				 //       "sslfactory=org.postgresql.ssl.NonValidatingFactory";
				      String user = "skybuy_feature";
				      String password = "Z4Z6EckHng4koKLbDei5";
				        
				
				      con = DriverManager.getConnection(url, user, password);

			} catch (Exception e) {

				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;

			}

			if (con != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
	
	
	  }
	public static void closeSshtunnel(){
		session.disconnect();
		}
	   public static String getSMSCodeAcceptOrder() throws SQLException{
		   String code = "0";
		 
		      java.sql.Statement stmt1 = con.createStatement();


		      String sql = "select text from sms_message order by id desc;";
		      
		      System.out.println(sql +"!!!!!!!!");;
		     // stmt4.executeUpdate("use "+""+";");
		      ResultSet set = stmt1.executeQuery(sql);
		    
		      set.next();
		      System.out.println(set.getString(1));	
		      String[] Pass = set.getString(1).split(" ");
			  	
			  	code = Pass[7];
			  	 System.out.println(code);	
		      
		    
		  return code;
		  
	  }	
	   public static void clearBD() throws SQLException{
		
		 
		      java.sql.Statement stmt2 = con.createStatement();


		      String sql = "delete FROM public.cart_item as ci where ci.cart_id in(\r\n" + 
		      		"	select id from public.cart where cart.order_id in(\r\n" + 
		      		"       select id from public.order as o where o.u_buyer in \r\n" + 
		      		"    		(select id from public.user where email ='skymilnbuy@gmail.com')));\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"delete FROM public.cart_item as ci\r\n" + 
		      		"where ci.cart_no_user_id in(\r\n" + 
		      		"    select id FROM public.cart_no_user as cnu where cnu.user_cart_id in(\r\n" + 
		      		"        select id from public.cart where cart.order_id in(\r\n" + 
		      		"    		select id from public.order as o where o.u_buyer in \r\n" + 
		      		"    			(select id from public.user where email ='skymilnbuy@gmail.com'))));\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"delete FROM public.cart_no_user as cnu\r\n" + 
		      		"where cnu.user_cart_id in(\r\n" + 
		      		"  select id from public.cart where cart.order_id in(\r\n" + 
		      		"    select id from public.order as o where o.u_buyer in \r\n" + 
		      		"    		(select id from public.user where email ='skymilnbuy@gmail.com')));\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"delete from public.cart where cart.order_id in(\r\n" + 
		      		"	select id from public.order as o where o.u_buyer in \r\n" + 
		      		"    		(select id from public.user where email ='skymilnbuy@gmail.com'));\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"\r\n" + 
		      		"delete from public.order as o where o.u_buyer in \r\n" + 
		      		"	(select id from public.user where email ='skymilnbuy@gmail.com');\r\n" + 
		      		"\r\n" + 
		      		"delete from public.user where email ='skymilnbuy@gmail.com'";
		      
		    //  System.out.println(sql +"!!!!!!!!");;
		     // stmt4.executeUpdate("use "+""+";");
		      stmt2.execute(sql);
		    
		      
			  	
			  	
		      
	   
	  }	   
}
	
	
	
	
  
