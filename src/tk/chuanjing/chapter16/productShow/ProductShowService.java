package tk.chuanjing.chapter16.productShow;

import java.sql.SQLException;
import java.util.List;

public class ProductShowService {

	public List<ProductShow> findAll() throws SQLException {
		ProductShowDao productDao = new ProductShowDao();
		return productDao.findAll();
	}

}
