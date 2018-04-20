package programan.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import programan.dao.AuthorDao;
import programan.pojo.ArticleType;
import programan.pojo.Author;

@Repository(value="AuthorDao")
public class AuthorDaoImpl implements AuthorDao {

	@Resource
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	public Author loginIn(String userName, String passWord) {
		// TODO Auto-generated method stub
//		System.out.println("userName:"+userName);
//		System.out.println("passWord:"+passWord);
		session=this.sessionFactory.getCurrentSession();
		String SQL = "SELECT * FROM author WHERE user_name=?";
		@SuppressWarnings("unchecked")
		Author author=(Author)session.createSQLQuery(SQL).addEntity(Author.class)
				.setString(0, userName).uniqueResult();
//		int result = 0;
		if(author!=null){
			String queryPassWord = author.getPassWord();
//			System.out.println("数据库密码:"+queryPassWord);
//			System.out.println("输入密码:"+passWord);
			if(passWord.equals(queryPassWord)){
				System.out.println("匹配成功");
//				result = 1;
				return author;
			}
			else{
				System.out.println("匹配失败");
//				result = 0;
			}
				
		}
		else{
			System.out.println("没进去");
//			result = 0;
		}
		
		return null;
	}
	
	@Override
	public Author regist(Author author){
		
		session = this.sessionFactory.getCurrentSession();
		String SQL = "SELECT * FROM author WHERE user_name=?";
		Author checkAuthor = (Author)session.createSQLQuery(SQL).addEntity(Author.class)
				.setString(0, author.getUserName()).uniqueResult();
		if(checkAuthor==null){
			session.save(author);
			String SQL1 = "SELECT * FROM author WHERE user_name=?";
			Author authorResult = (Author)session.createSQLQuery(SQL1).addEntity(Author.class)
					.setString(0, author.getUserName()).uniqueResult();
			return authorResult;
		}
		else{
			System.out.println("该用户名已经被注册");
		}
		return null;
		
	}

}
