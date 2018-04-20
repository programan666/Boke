package programan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import programan.dao.AuthorDao;
import programan.pojo.Author;
import programan.service.AuthorService;


@Transactional
@Service(value="authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public Author loginIn(String userName, String passWord) {
		// TODO Auto-generated method stub
		return this.authorDao.loginIn(userName, passWord);
	}
	
	@Override
	public Author regist(Author author){
		// TODO Auto-generated method stub
		return this.authorDao.regist(author);
	}

}
