package programan.dao;

import java.util.List;

import programan.pojo.Article;

public interface ArticleDao {
	public void create(Article article);
	public List<Article> findAll();
	public List<Article> findByType(int articleTypeID);
}
