package programan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import programan.dao.ArticleTypeDao;
import programan.pojo.ArticleType;
import programan.service.ArticleTypeService;

@Transactional
@Service(value="articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {

	@Autowired
	private ArticleTypeDao articleTypeDao;
	
	@Override
	public List<ArticleType> findAll() {
		// TODO Auto-generated method stub
		System.out.println("进入了articleTypeService");
		return this.articleTypeDao.fandAll();
	}

}
