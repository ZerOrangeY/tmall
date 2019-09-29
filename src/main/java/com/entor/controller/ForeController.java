package com.entor.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONWriter;
import com.alibaba.fastjson.JSON;
import com.entor.dao.CategoryDao;
import com.entor.dao.OrderItemDao;
import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.PropertyValueDao;
import com.entor.dao.ReviewDao;
import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.Order;
import com.entor.entity.OrderItem;
import com.entor.entity.Product;
import com.entor.entity.PropertyValue;
import com.entor.entity.Review;
import com.entor.entity.User;
import com.entor.service.OrderService;
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
	@Resource
	private OrderItemDao oiDao;
	@Resource
	private OrderService orderService;
	/**
	 * 显示主页商品及类目
	 */
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
	/**
	 * 
	 * 跳转商品详情页
	 */
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
	/**
	 * 
	 *跳转我的订单
	 */
	@RequestMapping("/forebought")
	public String forebought(HttpServletRequest req,Page page) {
	
	
		return "fore/bought";
	}
	//点击购物车跳转
	@RequestMapping("/forecart")
	public String cart(HttpServletRequest req,Page page) {
	
		
		return "fore/cart";
	}
	//登录验证
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
			req.setAttribute("msg", "账号或密码错误,请重新输入");
			System.out.println(resultUser+"");
			return "fore/home";
		}
		
	}
	//搜索栏模糊查询商品
	@RequestMapping("/foresearch")
	public String search(HttpServletRequest req,Page page) {
		List<Category> cs = categoryDao.queryAll();
		String keyword = req.getParameter("keyword");
		List<Product> ps = productDao.queryByWord(keyword);
		
		req.setAttribute("cs", cs);
		req.setAttribute("ps", ps);
		
		return "fore/searchResult";
	}
	//搜索栏点击默认字段
	@RequestMapping("/forecategory")
	public String search(HttpServletRequest req,Page page,int cid) {
		List<Category> cs = categoryDao.queryAll();
		List<Product> ps = productDao.queryByCid(cid);
		
		req.setAttribute("cs", cs);
		req.setAttribute("ps", ps);
		
		return "fore/searchResult";
	}
	/**
	 * 立即购买已登录跳转购买页面
	 * @throws IOException 
	 */
	@RequestMapping("/forebuyone")
	public String userCheck(HttpServletRequest req,HttpServletResponse resp,int pid,int num) throws IOException {
		Order order = new Order();
		User u = (User)req.getAttribute("user");
		Product p = productDao.queryById(pid);
		order.setUser(u);
		int oid = orderService.add(order);
		order.setId(oid);
		OrderItem oi = new OrderItem(0,p,order,u,num);
		oiDao.add(oi);
		List<OrderItem> ois = new ArrayList<>();
		ois.add(oi);
		req.setAttribute("ois", ois);
		req.setAttribute("oid", oi.getId());
		req.setAttribute("total", num*p.getPromotePrice());
		return "fore/buy";
	}
	/**
	 * 提交订单,导入地址详情,跳转到付款页面
	 */
	@RequestMapping("/forecreateOrder")
	public String createOrder(HttpServletRequest req,Page page,int cid) {
		String oid = req.getParameter("orderId");
		
		
		return "fore/searchResult";
	}
	/**
	 * 立即购买未登录,弹窗验证
	 * @throws IOException 
	 */
	@RequestMapping("/forecheckLogin")
	@ResponseBody
	public String forecheckLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user==null) {
			System.out.println("验证未通过");
			return "fail";
		}else {
			System.out.println("验证通过");
			return "success";
			
		}
	}

	/**
	 *buttonLoginSubmitButton
	 */
	@RequestMapping("/foreloginAjax")
	@ResponseBody
	public String loginSubmit(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		User user = userDao.queryByUser(new User(req.getParameter("name"),req.getParameter("password"),0));
		System.out.println("==============================");
		System.out.println("立即购买:登录验证成功重载页面:forecheckAjax");
		if (user!=null) {
			req.getSession().setAttribute("user", user);
			return "success";
		}
		return "fail";
	}
}
