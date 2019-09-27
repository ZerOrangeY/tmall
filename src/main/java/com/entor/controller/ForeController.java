package com.entor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.dao.CategoryDao;
import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.PropertyValueDao;
import com.entor.dao.ReviewDao;
import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.entity.PropertyValue;
import com.entor.entity.Review;
import com.entor.entity.User;
import com.entor.util.Page;

@Controller
public class ForeController {
	
	@Resource
	private CategoryDao categoryDao;
	@Resource 
	private ProductDao productDao;
	@Resource
	private ProductImageDao pigDao;
	@Resource
	private PropertyValueDao pvDao;
	@Resource
	private ReviewDao rDao;
	@Resource
	private UserDao userDao;
	@RequestMapping("/tmall")
	public String home(HttpServletRequest req,HttpServletResponse resp,Page page) {
		List<Category> cs = categoryDao.queryAllForHome();
		List<List<Product>> productsByRow = new ArrayList<>();
		for (Category category : cs) {
			
			productsByRow.add(productDao.queryByCid(category.getId()));
		}
		for (Category category : cs) {
			category.setProductsByRow(productsByRow);

		}
		req.setAttribute("cs", cs);
		return "fore/home";
	}
	@RequestMapping("/foreproduct")
	public String foreproduct(HttpServletRequest req,int pid,Page page) {

		Product p = productDao.queryById(pid);
		Map<String,String> map = new HashMap<String,String>();
		map.put("type", "single");
		map.put("pid", p.getId()+"");
		p.setProductSingleImages(pigDao.queryByPid(map));
		map.clear();
		map.put("type", "detail");
		map.put("pid", p.getId()+"");
		p.setProductDetailImages(pigDao.queryByPid(map));
		List<PropertyValue> pvs = pvDao.queryByPid(pid);
		List<Review> rs = rDao.queryByPid(pid);
		//System.out.println("============="+p.getFirstProductImage().getId()+"==========");
		req.setAttribute("reviews", rs);
		req.setAttribute("p",p);
		req.setAttribute("pvs", pvs);
		return "fore/product";
	}
	
	@RequestMapping("/loginPage")
	public String loginPage(HttpServletRequest req,Page page) {
		
	
		return "fore/login";
	}
	@RequestMapping("/forebought")
	public String forebought(HttpServletRequest req,Page page) {
	
	
		return "fore/bought";
	}
	@RequestMapping("/forecart")
	public String cart(HttpServletRequest req,Page page) {
	
		
		return "fore/cart";
	}
	@RequestMapping("/forelogin")
	public String loginCheck(HttpServletRequest req,HttpSession session) {
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("password"));
		User resultUser= userDao.queryByUser(user);
		
		if (resultUser!=null) {
			System.out.println(resultUser);
			session.setAttribute("user", resultUser);
			
			return "redirect:tmall";
			
		}else {
			System.out.println(resultUser+"");
			return "fore/home";
		}
		
	}
	@RequestMapping("/foresearch")
	public String search(HttpServletRequest req,Page page) {
		List<Category> cs = categoryDao.queryAll();
		String keyword = req.getParameter("keyword");
		List<Product> ps = productDao.queryByWord(keyword);
		
		req.setAttribute("cs", cs);
		req.setAttribute("ps", ps);
		
		return "fore/searchResult";
	}
	@RequestMapping("/forecategory")
	public String search(HttpServletRequest req,Page page,int cid) {
		List<Category> cs = categoryDao.queryAll();
		List<Product> ps = productDao.queryByCid(cid);
		
		req.setAttribute("cs", cs);
		req.setAttribute("ps", ps);
		
		return "fore/searchResult";
	}
}
