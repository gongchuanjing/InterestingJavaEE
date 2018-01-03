package tk.chuanjing.chapter19.ajax.province_city;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import tk.chuanjing.utils.JDBCUtilsC3P0;

public class ProvinceAndCityDao {

	public List<Province> findAllProvince() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from chapter19_province";
		return qr.query(sql, new BeanListHandler<Province>(Province.class));
	}

	public List<City> findCityByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from chapter19_city where pid=?";
		return qr.query(sql, new BeanListHandler<City>(City.class), pid);
	}

}
