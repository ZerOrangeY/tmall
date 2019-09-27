package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.entity.ProductImage;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class ProductImageController {
	@Resource
	private ProductService pService;
	@Resource
	private ProductImageService pImageService;
	@RequestMapping("/admin_productImage_list")
	public String listCategory(HttpSession session,Page page,int pid) {
		
		Product p = pService.queryById(pid);
		Map<String,String> map = new HashMap<String,String>();
		map.put("type", "single");
		map.put("pid", p.getId()+"");
		p.setProductSingleImages(pImageService.queryByPid(map));
		map.clear();
		map.put("type", "detail");
		map.put("pid", p.getId()+"");
		p.setProductDetailImages(pImageService.queryByPid(map));
		session.setAttribute("pisSingle", p.getProductSingleImages());
		session.setAttribute("pisDetail", p.getProductDetailImages());
		session.setAttribute("p", p);
		session.setAttribute("page", page);
		return "admin/listProductImage";
	}
}
