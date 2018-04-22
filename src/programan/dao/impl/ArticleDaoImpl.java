package programan.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import programan.dao.ArticleDao;
import programan.pojo.Article;

@Repository(value="articleDao")
public class ArticleDaoImpl implements ArticleDao {

	@Resource
	private SessionFactory sessionFactory;
	private Session session;
	
	private String fileRoad;
	
	@Override
	public void create(Article article) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println("进入了articleDao1");
		session=this.sessionFactory.getCurrentSession();
	//	fileRoad = this.getClass().getClassLoader().getResource("/").getPath()+"programan/article/"+article.getId()+".html";
	//	fileRoad = this.getClass().getClassLoader().getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+"article/"+date.getTime()+".html";
		fileRoad = "/usr/local/nginx/html/bokeArticle/"+date.getTime()+".html";
		File f=new File(fileRoad);
		f.setWritable(true, false);   
		try {
			f.createNewFile();
			Runtime.getRuntime().exec("chmod 755 "+fileRoad);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print(fileRoad);
	//	File file = new File(fileRoad);
//		try { 
//			if(!file.exists()){
//				file.createNewFile();
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			FileWriter writer = new FileWriter(fileRoad);
	        writer.write("<html><head>");
	        writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
	        writer.write("<title>文章</title>");
	        writer.write("</head>");
	        writer.write("<body><pre>");
	        writer.write(article.getText());
	        writer.write("<pre/></body></html>");
	        writer.flush();
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		article.setArticleLink(fileRoad.replaceAll("/usr/local/nginx/html/", "http://www.programan.cn/"));
		article.setCreationDT(date.toString());
		session.save(article);		 
		
	}
	
	//返回所有文章
	@Override
	public List<Article> findAll(){
		System.out.println("进入了articleDao2");
		session=this.sessionFactory.getCurrentSession();
		String SQL="SELECT * FROM article";
		@SuppressWarnings("unchecked")
		List<Article> articles=session.createSQLQuery(SQL).addEntity(Article.class).list();
		return articles;
	}
	
	//根据文章类型返回相应的文章信息
	@Override
	public List<Article> findByType(int articleTypeID){
		System.out.println("进入了articleDao3");
		session=this.sessionFactory.getCurrentSession();
		String SQL="SELECT * FROM article WHERE article_type_id=?";
		@SuppressWarnings("unchecked")
		List<Article> articles=session.createSQLQuery(SQL).addEntity(Article.class)
						.setInteger(0, articleTypeID).list();
		System.out.println("&&&&&articles:--"+articles);
		return articles;
	}

}
