package com.jsp.jspwfm.Services;

import com.jsp.jspwfm.Dao.OrderDetailsRepository;
import com.jsp.jspwfm.Dao.ProductRepository;
import com.jsp.jspwfm.Dao.UsersRepository;
import com.jsp.jspwfm.Models.Entities.OrderDetails;
import com.jsp.jspwfm.Models.Entities.Product;
import com.jsp.jspwfm.Models.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	int userId;

	public User getUser(String username, String password) {
		return usersRepository.getUserByUsername(username, password);
	}

	public Boolean loginUser(String username, String password) {
		User user = usersRepository.getUserByUsername(username, password);
		if (user != null) {
			if (user != null && user.getUsername().equalsIgnoreCase(username)
					&& user.getPassword().equalsIgnoreCase(password)) {
				this.userId = user.getUser_id();
				return true;
			} else
				return false;
		} else {
			User useremil = usersRepository.getUserByEmail(username, password);
			if (useremil != null) {
				return true;
			} else {
				return false;
			}
		}

	}

	public Boolean checkUserId(Integer userId) {
//    	long l1 = userId;
		if (usersRepository.existsById(userId)) {
			return true;
		} else {
			return false;
		}

	}

	public User signUpUser(User user) {
		return usersRepository.save(user);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Boolean checkProductId(Integer productId) {
		return productRepository.existsById(productId);
	}

	public Boolean updateProductQuantity(Integer productQuantity, Integer productId) {
		
		Product prodObj = productRepository.getReferenceById(productId);
		System.out.println(prodObj.getProductQuantity());
		int newProductQuantity = prodObj.getProductQuantity() - productQuantity;
		prodObj.setProductQuantity(newProductQuantity);
		System.out.println(prodObj.getProductQuantity());

		Product p1 = new Product();
		p1.setProductId(prodObj.getProductId());
		p1.setProductName(prodObj.getProductName());
		p1.setProductQuantity(newProductQuantity);
		productRepository.save(p1);
		updateOrder(p1, productQuantity);

		return true;
	}

	public void updateOrder(Product p1, Integer noOfOrders) {
		if (orderDetailsRepository.existsById(p1.getProductId())) {
			OrderDetails o1 = orderDetailsRepository.getReferenceById(p1.getProductId());
			o1.setProdId(p1.getProductId());
			int num = o1.getNoOforders() + noOfOrders;
			o1.setNoOforders(num);
			;
			o1.setUserId(this.userId);
			orderDetailsRepository.save(o1);
		} else {
			OrderDetails o1 = new OrderDetails(p1.getProductId(), noOfOrders, this.userId);
			orderDetailsRepository.save(o1);
		}

	}

	public String getProductDetails(Integer id) {
		Product prodObj = productRepository.getReferenceById(id);
//    	int num = prodObj.getProductId();
		String str1 = String.valueOf(prodObj.getProductId());
		String str2 = prodObj.getProductName();
		String str3 = String.valueOf(prodObj.getProductQuantity());
		String strF = "ProductID : " + str1 + "  " + "ProductName : " + str2 + "  " + "ProductQuantity : " + str3;

		return strF;
	}

	public Integer demo11() {
		Product prodObj = productRepository.getReferenceById(2);
		System.out.println(prodObj.getProductQuantity());
		prodObj.setProductQuantity(20);
		Integer num = prodObj.getProductQuantity();
		System.out.println("UPDTED QQQ " + num);
		return num;

	}

	public OrderDetails getOrderDetailsByUserId(Integer userId) {
		return orderDetailsRepository.getOrderDetailsById(userId);
	}

}
