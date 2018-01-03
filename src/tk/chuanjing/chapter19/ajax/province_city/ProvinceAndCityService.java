package tk.chuanjing.chapter19.ajax.province_city;

import java.sql.SQLException;
import java.util.List;

public class ProvinceAndCityService {

	public List<Province> findAllProvince() throws SQLException {
		ProvinceAndCityDao provinceDao = new ProvinceAndCityDao();
		return provinceDao.findAllProvince();
	}

	public List<City> findCityByPid(String pid) throws SQLException {
		ProvinceAndCityDao provinceDao = new ProvinceAndCityDao();
		return provinceDao.findCityByPid(pid);
	}

}
