package programan.service;

import java.util.List;

import programan.pojo.Article;

public interface ArticleService {
	public void createArticle(Article article);
	public List<Article> findAll();
}
