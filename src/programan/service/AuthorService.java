package programan.service;

import programan.pojo.Author;

public interface AuthorService {
	public Author loginIn(String userName,String passWord);
	public Author regist(Author author);
}
