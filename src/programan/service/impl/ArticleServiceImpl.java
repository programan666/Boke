package programan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import programan.dao.ArticleDao;
import programan.pojo.Article;
import programan.service.ArticleService;

@Transactional
@Service(value="articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public void createArticle(Article article) {
		// TODO Auto-generated method stub
		System.out.println("进入了service1");
		this.articleDao.create(article);
	}
	
	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		System.out.println("进入了service2");
		return this.articleDao.findAll();
	}

}
