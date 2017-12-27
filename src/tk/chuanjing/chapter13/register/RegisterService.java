package tk.chuanjing.chapter13.register;

import java.sql.SQLException;

import tk.chuanjing.chapter12.login.User;

/**
 * 业务层注册用户的方法
 * @author ChuanJing
 *
 */
public class RegisterService {

	public boolean regist(User user) throws SQLException {
		RegisterDao userDao = new RegisterDao();
		int row = userDao.regist(user);
		
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

}
