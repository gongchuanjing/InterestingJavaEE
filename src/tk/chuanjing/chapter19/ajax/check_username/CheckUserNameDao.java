package tk.chuanjing.chapter19.ajax.check_username;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import tk.chuanjing.utils.JDBCUtilsC3P0;

public class CheckUserNameDao {

	public CheckUserNameBean findByUsername(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from users where username=?";
		return qr.query(sql, new BeanHandler<CheckUserNameBean>(CheckUserNameBean.class), username);
	}

}
