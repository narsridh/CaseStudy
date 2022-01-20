package com.onlineshoping.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshoping.bean.ItemList;
import com.onlineshoping.service.CartService;
import com.onlineshoping.service.CartServiceImpl;


public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CartService cartService=new CartServiceImpl();
		String userName=(String) session.getAttribute("name");
		ItemList cartlist=null;
		System.out.println("hiiiiiii");
		try {
			System.out.println(userName);
			cartlist=cartService.getItemsFromCart(userName);
			System.out.println(cartlist.getItems());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		session.setAttribute("cartlist", cartlist.getItems());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./mycart.jsp");
		dispatcher.forward(request, response);
	}

}
