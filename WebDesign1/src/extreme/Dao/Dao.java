package extreme.Dao;

import java.util.List;

import extreme.JavaBean.JavaBean;

public interface Dao {
	//保存用户到数据库
	public void save(JavaBean user);
	//根据用户名从数据库查找用户对象
	public JavaBean getUserByName(String name);
	//获取所有用户
	public List<JavaBean> getList();

}
