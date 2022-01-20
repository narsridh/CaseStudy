package com.onlineshoping.service;

import java.sql.SQLException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.onlineshoping.bean.Customer;
import com.onlineshoping.bean.InventoryItem;
import com.onlineshoping.bean.ProductList;
import com.onlineshoping.persistance.CustomerDao;
import com.onlineshoping.persistance.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService
{
CustomerDao customerDao=new CustomerDaoImpl();
	public boolean signingUp(Customer customer) throws ClassNotFoundException,SQLException
	{
			int  rows=customerDao.signUp(customer);
			if(rows>0) return true;
		return false;
	}

	public boolean logingIn(String name, String Password)throws ClassNotFoundException,SQLException
	{  
		Customer customer=customerDao.logIn(name, Password);
		
	if(customer!=null)
		return true;
	return false;
	}
	
	@Override
	public ProductList viewProduct() throws ClassNotFoundException, SQLException {
		ProductList product=null;
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8085/CatalogServiceProject/webapi/").path("products");

		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();
		
		product = response.readEntity(ProductList.class);
		System.out.println(response.getStatus());
//		System.out.println(product);
//		System.out.println(product.getProducts());
		return product;
	}

	@Override
	public boolean buyproduct(String procode, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub	
		InventoryItem inventory=null;
		InventoryItem inventory1=null;
		
		int available;
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8085/InventoryServiceProject/webapi/").path("inventoryItem/code/"+procode);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();
		inventory=response.readEntity(InventoryItem.class);
		available=inventory.getAvailableQuantity();
		System.out.println(available+"above if loop");
		if(quantity<=available) {
			available=available-quantity;
			System.out.println(available+"below if loop");
		
		WebTarget webTarget1 = client.target("http://localhost:8085/InventoryServiceProject/webapi/").path("inventoryItem/item/"+procode+"/"+available);
		Invocation.Builder invocationBuilder1 =  webTarget1.request(MediaType.APPLICATION_JSON);
		Response response1 = invocationBuilder1.get();
		inventory1=response1.readEntity(InventoryItem.class);
		}
		return true;
	}

}
