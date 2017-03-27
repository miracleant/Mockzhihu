package extreme.service;

import java.util.List;

import extreme.Dao.Dao;
import extreme.Dao.DaoImp;
import extreme.JavaBean.JavaBean;

public class UserService {
	
	private Dao dao =new DaoImp();
	
	
	
	
	//保存用户到数据库(注册)
	public void regist(JavaBean user){
		//1.校验用户名是否重复
		JavaBean exist = dao.getUserByName(user.getUsername());
		if(exist!=null){
			throw new RuntimeException("用户名已存在");
		}
		//2.保存到数据库(可能有异常抛出)
		dao.save(user);
	}
	
	
	
	
	//登陆验证
	public JavaBean login(JavaBean user){
		JavaBean demouser = null;
		//1.验证用户名是否存在
		demouser =dao.getUserByName(user.getUsername());
		if(demouser==null){
			throw new RuntimeException("用户名不存在");
		}
		//2.验证密码是否正确
		if(!demouser.getPassword().equals(user.getPassword())){
			throw new RuntimeException("密码错误，请重新输入");
		}
		return demouser;
	}
	
	//获取列表
	public List<JavaBean> getList(){
		return dao.getList();
	}

}
