package programan.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import programan.pojo.Article;
import programan.pojo.ArticleType;
import programan.service.ArticleService;



@Controller
@RequestMapping("articleController")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	public ArticleController(){
		System.out.println("@@@--controller成功读取");
	}
	
	@RequestMapping("article.do")
	@ResponseBody
	public String getarticle(@RequestBody Article article){
		System.out.println("进入了controller1");
		System.out.println("@@@"+article.getAuthor().getUserName());
		System.out.println("@@@"+article.getAuthor().getUserName());
		System.out.println("@@@@"+article.getArticleType().getName());
//		System.out.println(article.getText());
		this.articleService.createArticle(article);
		return "1";
	}
	
	@RequestMapping("test.do")
	public String test(){
		return "/test";
	}
	
	@RequestMapping("articleList.do")
	@ResponseBody
	public List<Article> getArticle(HttpServletRequest request){
		List<Article> articles;
	//	int articleTypeID = 0;
		if(request.getParameter("articleTypeID")==null){
			System.out.println("进入了controller2");
			articles = this.articleService.findAll();
//			request.setAttribute("article", articles);
			
		}
		else{
			System.out.println("进入了controller3");
			System.out.println(request);
			int articleTypeID = Integer.parseInt(request.getParameter("articleTypeID"));
			articles = this.articleService.findByType(articleTypeID);
//			System.out.println("%%%%%%%%%%%%%%%%%%%%");
//			request.setAttribute("article", articles);
		}
		return articles;
		
	}
	
//	@RequestMapping("articleListByType.do")
//	@ResponseBody
//	public List<Article> getarticleByType(HttpServletRequest request){
//		System.out.println("进入了controller3");
//		System.out.println(request);
//		int articleTypeID = Integer.parseInt(request.getParameter("articleTypeID"));
//		List<Article> articles = this.articleService.findByType(articleTypeID);
////		request.setAttribute("article", articles);
//		return articles;
//	}
	
	
}
