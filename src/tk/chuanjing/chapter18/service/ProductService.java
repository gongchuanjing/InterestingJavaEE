package tk.chuanjing.chapter18.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import tk.chuanjing.chapter18.dao.ProductDao;
import tk.chuanjing.chapter18.domain.PageBean;
import tk.chuanjing.chapter18.domain.Product;
import tk.chuanjing.utils.JDBCUtilsC3P0;

/**
 * 商品管理的业务层的类
 * @author ChuanJing
 *
 */
public class ProductService {

	/**
	 * 查询所有商品的方法:
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.findAll();
	}
	
	/**
	 * 保存商品的方法:
	 * @param product
	 * @throws SQLException 
	 */
	public void save(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.save(product);
	}
	
	/**
	 * 根据ID查询商品的方法:
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product findById(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.findById(pid);
	}
	
	/**
	 * 修改商品的方法:
	 * @param product
	 * @throws SQLException 
	 */
	public void update(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.update(product);
	}
	
	/**
	 * 业务层删除某一个商品的方法:
	 * @param pid
	 * @throws SQLException 
	 */
	public void delete(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.delete(pid);
	}

	/**
	 * 业务层删除多条记录的操作
	 * @param ids
	 */
	public void deleteAll(String[] ids) {
		Connection conn = JDBCUtilsC3P0.getConnection();
		try {
			conn.setAutoCommit(false);
			
			ProductDao productDao = new ProductDao();
			for (String id : ids) {
				productDao.delete(conn, id);
			}
			
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		}
	}
	
	public List<Product> search(String pname) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.search(pname);
	}
	
	/**
	 * 业务层分页查询商品的方法:
	 * @param currPage
	 * @return
	 * @throws SQLException
	 * 
	 * 	private int currPage; 		// 当前页数.
		private int pageSize;		// 每页记录数.
		private int totalCount; 	// 总记录数.
		private int totalPage; 		// 总页数.
		private List<Product> list; // 每页的数据的集合
	 */
	public PageBean findByPage(int currPage) throws SQLException {
		PageBean pageBean = new PageBean();
		
		// 设置pageBean的参数
		
		// 设置当前页数
		pageBean.setCurrPage(currPage);
		
		// 设置每页显示记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		
		// 设置总记录数
		ProductDao productDao = new ProductDao();
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		// 设置总页数:方法一：
		/*
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		*/
		// 设置总页数:方法二：
		double tc = totalCount;
		Double ceil = Math.ceil(tc / pageSize);
		int totalPage = ceil.intValue();
		pageBean.setTotalPage(totalPage);
		
		// 设置每页显示的数据的集合
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
}
