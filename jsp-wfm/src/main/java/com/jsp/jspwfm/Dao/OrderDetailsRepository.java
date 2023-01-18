package com.jsp.jspwfm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.jspwfm.Models.Entities.OrderDetails;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{
	
//	@Query(value = "SELECT o.prod_id as prodId, o.no_oforders as noOforders, o.user_id as userId FROM order_details o WHERE user_id = :userId", nativeQuery = true)
//  public OrderDetails getOrderDetailsById(Integer userId);
	
	@Query("select o from OrderDetails o where o.userId = :user_id")
	  public OrderDetails getOrderDetailsById(Integer user_id);

}
