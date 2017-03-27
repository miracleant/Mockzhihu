package top.karls.extreme.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import top.karls.extreme.JavaBean.JavaBean;
import top.karls.extreme.utils.JDBCUtils;

public class DaoImp implements Dao{
	
	
	//保存用户到数据库
	public void save(JavaBean user) {
		//1.获得连接
		Connection conn = JDBCUtils.getConnection();
		//2.sql语句
		String sql = "insert into userInfo (username,password) values (?,?)";
		PreparedStatement ps = null;
		try {
			//3.创建preparedstatement对象
			 ps = conn.prepareStatement(sql);
			 //4.设置参数
			 ps.setString(1, user.getUsername());
			 ps.setString(2, user.getPassword());
			 //5.执行sql
			int result =  ps.executeUpdate();
			if(result!=1){
				throw new RuntimeException("注册用户失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("注册用户失败");
		}finally{
			//6.关闭资源
			JDBCUtils.close(conn, ps, null);
		}
		

		
	}
	//根据用户名从数据库查找用户对象
	public JavaBean getUserByName(String name) {
		JavaBean User = null;
		//1.获得连接
		Connection conn = JDBCUtils.getConnection();
		//2.sql语句
		String sql = "select * from userInfo where username=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3.创建preparedstatement对象
			 ps = conn.prepareStatement(sql);
			 //4.设置参数
			 ps.setString(1, name);
			 //5.执行sql
			 rs =  ps.executeQuery();
			 if(rs.next()){
				 User = new JavaBean();              //勿漏
				 User.setUsername(rs.getString("username"));
				 User.setPassword(rs.getString("password"));
			 }
			 return User;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户失败");
		}finally{
			//6.关闭资源
			JDBCUtils.close(conn, ps, rs);
		}

	}
	
	



}
