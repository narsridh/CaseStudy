package com.onlineshoping.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshoping.bean.Item;
import com.onlineshoping.bean.ItemList;
import com.onlineshoping.service.CartService;
import com.onlineshoping.service.CartServiceImpl;
import com.onlineshoping.service.CustomerService;
import com.onlineshoping.service.CustomerServiceImpl;


public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CartService cartser=new CartServiceImpl();
		String userName=(String) session.getAttribute("name");
		String procode=request.getParameter("item");
		String quantity=request.getParameter("quantity");
		Item items = new Item();
//		System.out.println(procode);
//		System.out.println(quantity);
		int quantityint=Integer.parseInt(quantity);
		items.setItems(procode);
		items.setUserName(userName);
		items.setQuantity(quantityint);
		ItemList cartlist=null;
		CustomerService cusser=new CustomerServiceImpl();
		try {
			if(cusser.buyproduct(procode,quantityint)) {
				System.out.println(items.getUserName());
				cartser.deleteItemsFromCart(items);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			
			System.out.println(cartlist);
			cartlist=cartser.getItemsFromCart(userName);
			System.out.println(cartlist+"below");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("cartlist", cartlist.getItems());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./mycart.jsp");
		dispatcher.forward(request, response);
	}

	}


