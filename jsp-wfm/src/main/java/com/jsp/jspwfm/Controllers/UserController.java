package com.jsp.jspwfm.Controllers;

import com.jsp.jspwfm.Models.Entities.OrderDetails;
import com.jsp.jspwfm.Models.Entities.Product;
import com.jsp.jspwfm.Models.Entities.User;
import com.jsp.jspwfm.Services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//WRITTEN ALL THE RSET API's TO TEST IN POSTMAN
//PLEASE CREATE DATABASE WITH NAME doodle in MYSQL


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	

	//API-1 : Enter the UserDetails in the body of post method of POSTMAN
	//{
	//    "user_id" : 125,
	//    "username" : "bindu",
	//    "password" : "bindudu333",
	//    "email" : "bindu@000",
	//    "gender" : "female",
	//    "age" : 19
	//} 
	
	@PostMapping("/signupuser")
	public ResponseEntity<String> signUpUser(@RequestBody User user) {
		User user2 = userService.signUpUser(user);
		if (user2 != null) {
			return ResponseEntity.status(200).body("SIGN UP SUCCESSFULL");
		} else {
			return ResponseEntity.status(400).body("SIGN UP FAILED PLEASE ENTER VALID DETAILS");

		}
	}
	
	//API-2 : Enter the ProductDetails in the body of post method of POSTMAN
	//	{
	//	    "productId" : 121 ,
	//	    "productName" : "phone",
	//	    "productQuantity" : 100
	//	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product product2 = userService.addProduct(product);
		return ResponseEntity.status(200).body(product2);
	}
	
	

	//API-3 : Enter the UserName/Email and Password  in the Header of GET method of POSTMAN as key and Value Pair
	// userId :  bindu/bindu@000
	// Password : bindudu333
	
	
	@RequestMapping("/loginuser")
	public ResponseEntity<String> loginUser(@RequestHeader String username, @RequestHeader String password) {
		if (userService.loginUser(username, password)) {
			return ResponseEntity.status(200).body("LOGIN SUCCESS");

		} else {
			return ResponseEntity.status(200).body("Login Failed");

		}

	}
	
	
	//API-4 : Enter the UserId , ProductId and ProductQuantity  in the Header of GET method of POSTMAN as key and Value Pair
	// userId :  125
	// productId : 2
	//productQuantity : 20
	

	@RequestMapping("/orderbyuserid")
	public ResponseEntity<String> oderByUserId(@RequestHeader Integer userId, @RequestHeader Integer productId,
			@RequestHeader Integer productQuantity) {
		if (userService.checkUserId(userId)) {
			if (userService.checkProductId(productId)) {
				userService.updateProductQuantity(productQuantity, productId);
				return ResponseEntity.status(200).body("ORDER SUCCESS");
			} else {
				return ResponseEntity.status(200).body("Order Failed Please Try again with Correct ProductID");
			}
		} else {
			return ResponseEntity.status(200).body("Order Failed!!! Please Enter Valid USERID");
		}

	}

	
	//API-5 : Enter the  ProductId  in the Header of GET method of POSTMAN as key and Value Pair
	//To get Product Details Based on ProductID
	// productId : 2


	@RequestMapping("getproductdetails")
	public ResponseEntity<String> getProductDetails(@RequestHeader Integer productId) {
//    	Product product = userService.getProductDetails(productId);
		return ResponseEntity.status(200).body(userService.getProductDetails(productId));
	}
	
	//API-6 : Enter the  UserId  in the Header of GET method of POSTMAN as key and Value Pair
	//To get Order Details(Number Of Orders Placed by each User) Based on UserID
	// userId :  125

	@RequestMapping("getordedetailsbyuserid")
	public ResponseEntity<OrderDetails> getOrderDetailsByUserId(@RequestHeader Integer userId) {
		OrderDetails details = userService.getOrderDetailsByUserId(userId);
		return ResponseEntity.status(200).body(details);
	}

	
	
	
}
