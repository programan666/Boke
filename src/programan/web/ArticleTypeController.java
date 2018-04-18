package programan.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import programan.pojo.Article;
import programan.pojo.ArticleType;
import programan.service.ArticleTypeService;


@Controller
@RequestMapping("articleTypeController")
public class ArticleTypeController {
	
	@Autowired
	private ArticleTypeService articleTypeService;
	
	@RequestMapping("articleType.do")
	@ResponseBody
	public List<ArticleType> getArticleTypeList(HttpServletRequest request){
	//	System.out.println("进入了controller2");
		List<ArticleType> articleTypes = this.articleTypeService.findAll();
//			request.setAttribute("article", articles);
		return articleTypes;
	}
	
}
