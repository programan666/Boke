package programan.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import programan.pojo.Author;
import programan.service.AuthorService;

@Controller
@RequestMapping("authorController")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("author.do")
	@ResponseBody
	public Author getarticle(String userName,String passWord){
		Author result = this.authorService.loginIn(userName, passWord);
		System.out.println("result:"+result);
		return result;
	}
	
	@RequestMapping("authorRegist.do")
	@ResponseBody
	public Author getAuthorInfo(@RequestBody Author author){
	//	System.out.print("$$$$author.username:"+author.getUserName());
		Author result = this.authorService.regist(author);
		if(result!=null){
			return result;
		}
		author.setId(-1);
		return author;
	}
	
}
