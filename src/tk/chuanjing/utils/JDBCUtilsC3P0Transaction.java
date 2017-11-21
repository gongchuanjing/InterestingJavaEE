package tk.chuanjing.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用C3P0的 JDBC的工具类
 * 
 * @author ChuanJing
 * @date 2017年5月29日 下午9:01:22
 * @version 1.0
 */
public class JDBCUtilsC3P0Transaction {
	
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
	
	/**
	 * 获得连接的方法
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = tl.get();
		try {
			if (conn == null) {
				conn = DATA_SOURCE.getConnection();
				tl.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void beginTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			conn = DATA_SOURCE.getConnection();
			tl.set(conn);
			conn.setAutoCommit(false);
		} else {
			throw new SQLException("事务已经开启，在没有结束当前事务时，不能再开启事务！");
		}
		
	}
	
	public static void commitTransaction() throws SQLException {
		Connection conn = tl.get();
		
		if(conn == null) {
			throw new SQLException("当前没有事务，所以不能提交事务！");
		}

		conn.commit();
		conn.close();
//		tl.remove();
	}
	
	public static void rollBackTransaction() throws SQLException {
		Connection conn = tl.get();
		if(conn == null) {
			throw new SQLException("当前没有事务，所以不能回滚事务！");
		}

		conn.rollback();
		conn.close();
//		tl.remove();
	}
	
	public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			statement = null;
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			connection = null;
		}
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			resultSet = null;
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			statement = null;
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			connection = null;
		}
	}
}
