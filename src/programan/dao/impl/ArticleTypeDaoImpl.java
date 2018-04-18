package programan.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import programan.dao.ArticleTypeDao;
import programan.pojo.Article;
import programan.pojo.ArticleType;

@Repository(value="articleTypeDao")
public class ArticleTypeDaoImpl implements ArticleTypeDao {

	@Resource
	private SessionFactory sessionFactory;
	private Session session;
	
	
	@Override
	public List<ArticleType> fandAll() {
		// TODO Auto-generated method stub
		session=this.sessionFactory.getCurrentSession();
		String SQL="SELECT * FROM article_type";
		@SuppressWarnings("unchecked")
		List<ArticleType> articleTypes=session.createSQLQuery(SQL).addEntity(ArticleType.class).list();
		return articleTypes;
	}

}
