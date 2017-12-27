package tk.chuanjing.chapter12.login;

import java.sql.SQLException;

/**
 * 登录案例的Service的代码
 * @author ChuanJing
 *
 */
public class LoginService {

	/**
	 * 业务层用户登录的方法
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException {
		// 调用DAO完成对数据库查询的操作
		LoginDao userDao = new LoginDao();
		return userDao.login(user);
	}

}
