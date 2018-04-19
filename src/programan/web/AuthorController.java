package programan.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import programan.service.AuthorService;

@Controller
@RequestMapping("authorController")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("author.do")
	@ResponseBody
	public String getarticle(String userName,String passWord){
		String result;
		result = Integer.toString(this.authorService.loginIn(userName, passWord));
		System.out.println("result:"+result);
		return result;
	}
}
