package programan.dao;

import programan.pojo.Author;

public interface AuthorDao {
	public Author loginIn(String userName,String passWord);
	public Author regist(Author author);
}
