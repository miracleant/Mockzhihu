package top.karls.extreme.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	static{
		Properties prop = new Properties();
		InputStream is = JDBCUtils.class.getResourceAsStream("/db.properties");
		try {
			prop.load(is);
			is.close();
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取db文件失败");
		}
		
		try {
			//注册驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("注册驱动失败");
		}
	}
	
	
	
	//获得连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//连接
			conn =DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("连接数据库失败");
		}
		return conn;
	}

  //关闭资源
	public static void close(Connection conn, Statement st, ResultSet rs){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


}
