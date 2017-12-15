package tk.chuanjing.chapter19.ajax.search_word;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import tk.chuanjing.utils.JDBCUtilsC3P0;

public class SearchWordDao {

	public List<SearchWord> search(String word) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtilsC3P0.getDataSource());
		String sql = "select * from words where chapter19_words like ? limit 5";
		return qr.query(sql, new BeanListHandler<SearchWord>(SearchWord.class), word+"%");
	}

}
