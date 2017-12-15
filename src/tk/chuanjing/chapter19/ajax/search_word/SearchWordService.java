package tk.chuanjing.chapter19.ajax.search_word;

import java.sql.SQLException;
import java.util.List;

public class SearchWordService {

	public List<SearchWord> search(String word) throws SQLException {
		SearchWordDao wordDao = new SearchWordDao();
		return wordDao.search(word);
	}

}
