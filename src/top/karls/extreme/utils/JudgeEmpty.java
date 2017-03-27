package top.karls.extreme.utils;

import java.util.HashMap;
import java.util.Map;

import top.karls.extreme.JavaBean.JavaBean;

public class JudgeEmpty {
	public static Map<String, String> check(JavaBean user){
		Map< String ,String > map = new HashMap<String, String>();
		if(user.getUsername()==null||"".equals(user.getUsername().trim())){
			map.put("username", "用户名不能为空");
		}
		if(user.getPassword()==null||"".equals(user.getPassword().trim())){
			map.put("password", "密码不能为空");
		}
		return map;
	}

}
