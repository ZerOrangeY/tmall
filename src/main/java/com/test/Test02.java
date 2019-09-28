package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Order;
import com.entor.entity.User;
import com.entor.service.OrderService;

public class Test02 {
	public static void main(String[] args) {
		/**
		 * 测试OrderMapper能否插入空值
		 */
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService oservice = (OrderService) context.getBean("orderService");
		Order o = new Order();
		User u = new User();
		u.setId(2);
		o.setUser(u);
		System.out.println("插入的ID:"+oservice.add(o));
		
	}
}	
