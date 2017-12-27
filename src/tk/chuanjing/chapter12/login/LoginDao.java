package tk.chuanjing.chapter12.login;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import tk.chuanjing.utils.JDBCUtilsC3P0;

/**
 * 登录的案例的DAO的代码
 * @author ChuanJing
 *
 */
public class LoginDao {

	/**
	 * 用户登录的DAO的方法
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		
		String sql = "select * from users where username=? and password=?";
		Object[] params = {user.getUsername(), user.getPassword()};
		
		User existUser = qr.query(sql, new BeanHandler<User>(User.class), params);
		return existUser;
	}

}
