package tk.chuanjing.chapter17.transaction;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;

import tk.chuanjing.utils.JDBCUtilsC3P0;

public class AccountService {

	/**
	 * 使用DBUtils进行事务的管理:
	 * @param from
	 * @param to
	 * @param money
	 */
	public boolean account(String from, String to, double money) {
		AccountDao ad = new AccountDao();
		Connection conn = JDBCUtilsC3P0.getConnection();
		
		try{
			conn.setAutoCommit(false);
			int row1 = ad.outMoney(conn, from, money);
//			int s = 5/0;
			int row2 = ad.inMoney(conn, to, money);
			
			DbUtils.commitAndCloseQuietly(conn);
			
			if ( row1 == 1 && row2 == 1 ) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			DbUtils.rollbackAndCloseQuietly(conn);
			return false;
		}
	}
	
	/**
	 * 事务管理的第二种方法:绑定到当前线程
	 * @param from
	 * @param to
	 * @param money
	 */
	/*
	public boolean account(String from, String to, double money) {
		AccountDao ad = new AccountDao();
		
		try{
			JDBCUtilsC3P0Transaction.beginTransaction();
			
			int row1 = ad.outMoney(from, money);
			int s = 5/0;
			int row2 = ad.inMoney(to, money);
			
			JDBCUtilsC3P0Transaction.commitTransaction();
			
			if ( row1 == 1 && row2 == 1 ) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				JDBCUtilsC3P0Transaction.rollBackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			return false;
		}
	}
	*/
	
	/**
	 * 事务管理的第一种办法发:向下传递Connection:DBUtils就是内部就是采用这种方式
	 * 业务层转账的方法：
	 * @param from
	 * @param to
	 * @param money
	 */
	/*
	public boolean account1(String from, String to, double money) {
		AccountDao ad = new AccountDao();
		Connection conn = JDBCUtilsC3P0.getConnection();
		
		try{
			conn.setAutoCommit(false);
			
			int row1 = ad.outMoney(conn, from, money);
//			int s = 5/0;
			int row2 = ad.inMoney(conn, to, money);
			
			conn.commit();
			
			if ( row1 == 1 && row2 == 1 ) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			return false;
		}
	}
	*/

}
