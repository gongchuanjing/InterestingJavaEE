package tk.chuanjing.chapter18.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import tk.chuanjing.chapter18.domain.Product;
import tk.chuanjing.utils.JDBCUtilsC3P0;

/**
 * 商品管理的DAO的代码
 * @author ChuanJing
 *
 */
public class ProductDao {

	/**
	 * DAO中查询所有商品的方法
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from chapter18_product order by pdate desc";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

	/**
	 * DAO中的保存商品的方法
	 * @param product
	 * @throws SQLException
	 */
	public void save(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "insert into chapter18_product values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { product.getPid(), product.getPname(), product.getMarket_price(), 
				product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(),
				product.getPdesc(), product.getPflag(), product.getCid() };
		qr.update(sql, params);
	}

	/**
	 * DAO中根据ID查询商品的方法:
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product findById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from chapter18_product where pid= ?";
		return qr.query(sql, new BeanHandler<Product>(Product.class), pid);
	}
	
	/**
	 * DAO中修改商品的方法
	 * @param product
	 * @throws SQLException 
	 */
	public void update(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "update chapter18_product set pname=?, market_price=?, shop_price=?, pimage=?, pdate=?, is_hot=?, pdesc=?, pflag=?, cid=? where pid=?";
		Object[] params = { product.getPname(), product.getMarket_price(), 
				product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(),
				product.getPdesc(), product.getPflag(), product.getCid(), product.getPid() };
		qr.update(sql, params);
	}

	public void delete(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "delete from chapter18_product where pid = ?";
		qr.update(sql, pid);
	}

	public void delete(Connection conn, String pid) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "delete from chapter18_product where pid = ?";
		qr.update(conn, sql, pid);
	}

	public List<Product> search(String pname) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from chapter18_product where pname like ? order by pdate desc";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), "%"+pname+"%");
		return list;
	}

	public int findCount() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select count(*) from chapter18_product";
		Long count = (Long)qr.query(sql, new ScalarHandler());
		return count.intValue();
	}

	public List<Product> findByPage(int begin, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from chapter18_product order by pdate desc limit ?,?";
		Object[] params = {begin, pageSize};
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), params);
		return list;
	}
}