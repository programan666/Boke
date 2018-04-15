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
	public String getarticle(@RequestBody Article article){
		System.out.println("进入了controller1");
		System.out.println("@@@"+article.getAuthor().getUserName());
		System.out.println("@@@"+article.getAuthor().getUserName());
		System.out.println("@@@@"+article.getArticleType().getName());
//		System.out.println(article.getText());
		this.articleService.createArticle(article);
		return "/test";
	}
	
	@RequestMapping("articleList.do")
	@ResponseBody
	public List<Article> getarticle(HttpServletRequest request){
		System.out.println("进入了controller2");
		List<Article> articles = this.articleService.findAll();
//		request.setAttribute("article", articles);
		return articles;
	}
	
	
}
