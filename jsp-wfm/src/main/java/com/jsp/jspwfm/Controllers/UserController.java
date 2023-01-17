package com.jsp.jspwfm.Controllers;

import com.jsp.jspwfm.Models.Entities.User;
import com.jsp.jspwfm.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @RequestMapping("/getUser")
    public ResponseEntity testFetchUser(@RequestParam String username,@RequestParam String password)
    {
        return new ResponseEntity<>(userService.getUser(username,password), HttpStatusCode.valueOf(200));
    }
    
    @RequestMapping("/regesteruser")
    public ResponseEntity regesterUser(@RequestBody User user)
    {
    	User user1 = userService.regesterUser(user);
    	if(user1!=null)
    		return new ResponseEntity<>(user1 , HttpStatusCode.valueOf(200));
    	else
    		return new ResponseEntity<>(null , HttpStatusCode.valueOf(400));

    }

    
}
