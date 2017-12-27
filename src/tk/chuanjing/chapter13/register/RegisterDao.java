package tk.chuanjing.chapter13.register;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import tk.chuanjing.chapter12.login.User;
import tk.chuanjing.utils.JDBCUtilsC3P0;

/**
 * DAO中的用户的注册的方法
 * @author ChuanJing
 *
 */
public class RegisterDao {

	public int regist(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		
		String sql = "INSERT INTO `users` (`id`, `username`, `password`, `nickname`, `email`, `sex`, `age`, `telephone`) values(null,?,?,?,?,?,?,?)";
		
		Object[] params = {user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(),
						   user.getSex(),user.getAge(), user.getTelephone()};
		return qr.update(sql, params);
	}
	
}
