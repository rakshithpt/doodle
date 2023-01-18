package com.jsp.jspwfm.Dao;

import com.jsp.jspwfm.Models.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<User,Integer> {

//    @Query(value = "SELECT u.user_id as user_id, u.username as username, u.password as password, u.email as email , u.gender as gender , u.age as age FROM Users u WHERE username = :username & password = :password", nativeQuery = true)
//    public User getUserByUsername(String username , String password);
	
	@Query("select u from User u where u.username = :username and u.password = :password")
  public User getUserByUsername(String username , String password);
	
	
	@Query("select u from User u where u.email = :username and u.password = :password")
	  public User getUserByEmail(String username , String password);
	
	
//	@Query("select u from User u where u.username = :username and u.password = :password")
//	  public Boolean loginUser(String username , String password);

}
