package tk.chuanjing.chapter16.productShow;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import tk.chuanjing.utils.JDBCUtilsC3P0;

public class ProductShowDao {

	public List<ProductShow> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		
		String sql = "select * from chapter18_product order by pdate desc";
		return qr.query(sql , new BeanListHandler<ProductShow>(ProductShow.class));
//		Product query = qr.query(sql , new BeanHandler<Product>(Product.class));
//		List<Product> list = new ArrayList<Product>();
//		list.add(query);
//		return list;
	}

}
