package tk.chuanjing.chapter17.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {

	/**
	 * 使用DBUtils进行事务的管理
	 * @param conn
	 * @param from
	 * @param money
	 * @return
	 * @throws SQLException
	 */
	public int outMoney(Connection conn, String from, double money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set money=money-? where name=?";
		Object[] params = {money, from};
		int row = qr.update(conn, sql, params);
		return row;
	}

	/**
	 * 使用DBUtils进行事务的管理
	 * @param conn
	 * @param to
	 * @param money
	 * @return
	 * @throws SQLException
	 */
	public int inMoney(Connection conn, String to, double money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set money=money+? where name=?";
		Object[] params = {money, to};
		int row = qr.update(conn, sql, params);
		return row;
	}
	/*
	//事务管理的第二种方法:绑定到当前线程
	public int outMoney(String from, double money) throws SQLException {
		Connection conn = JDBCUtilsC3P0Transaction.getConnection();
		String sql = "update account set money=money-? where name=?";
	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, from);
		int row = ps.executeUpdate();
		
		JDBCUtilsC3P0.close(null, ps);
		
		return row;
	}

	//事务管理的第二种方法:绑定到当前线程
	public int inMoney(String to, double money) throws SQLException {
		Connection conn = JDBCUtilsC3P0Transaction.getConnection();
		String sql = "update account set money=money+? where name=?";
	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, to);
		int row = ps.executeUpdate();
		
		JDBCUtilsC3P0.close(null, ps);
		
		return row;
	}
	*/
	
	/*
	事务管理的第一种办法发:向下传递Connection
	public int outMoney(Connection conn, String from, double money) throws SQLException {
		String sql = "update account set money=money-? where name=?";
	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, from);
		int row = ps.executeUpdate();
		
		JDBCUtilsC3P0.close(null, ps);
		
		return row;
	}

	事务管理的第一种办法发:向下传递Connection:
	public int inMoney(Connection conn, String to, double money) throws SQLException {
		String sql = "update account set money=money+? where name=?";
	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, to);
		int row = ps.executeUpdate();
		
		JDBCUtilsC3P0.close(null, ps);
		
		return row;
	}
	*/

	/**
	 * DAO的扣钱的方法
	 * @param from
	 * @param money
	 * @throws SQLException 
	 */
	/*
	public int outMoney(String from, double money) throws SQLException {
		Connection conn = JDBCUtilsC3P0.getConnection();
		String sql = "update account set money=money-? where name=?";
	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, from);
		int row = ps.executeUpdate();
		
		JDBCUtilsC3P0.close(conn, ps);
		
		return row;
	}
	*/

	/**
	 * DAO中给某个用户加钱的方法:
	 * @param to
	 * @param money
	 * @throws SQLException 
	 */
	/*
	public int inMoney(String to, double money) throws SQLException {
		Connection conn = JDBCUtilsC3P0.getConnection();
		String sql = "update account set money=money+? where name=?";
	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, to);
		int row = ps.executeUpdate();
		
		JDBCUtilsC3P0.close(conn, ps);
		
		return row;
	}
	*/
}
