package tk.chuanjing.chapter19.ajax.check_username;

import java.sql.SQLException;

public class CheckUserNameService {

	public CheckUserNameBean findByUsername(String username) throws SQLException {
		CheckUserNameDao userDao = new CheckUserNameDao();
		return userDao.findByUsername(username);
	}

}
