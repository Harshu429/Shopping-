package com.harshu.shoppin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harshu.shoppin.dto.Users;
import com.harshu.shoppin.entity.Orders;
import com.harshu.shoppin.entity.User;
import com.harshu.shoppin.service.UserServ;

@RestController
public class UserController {
	@Autowired
	UserServ us;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User u) {
		return us.saveUser(u);
	}
	    
	@GetMapping("/getorderById")
	public List<Orders> getOrderById (@RequestParam ("id") Integer id){
		return us.getOrdersById(id);
	}
//	@GetMapping("/getAllUser")
//	public List<User> getAllUser( ){
//		return us.getAllUser();
//	}
	@GetMapping("/allusers")
	public List<Users> getAllUsers() {
		return us.getAllUsers();
	} 
	
	@GetMapping("/allorders")
	public List<Orders> getAllOrders() {

		return us.getOrders();
	}

	@GetMapping("/orderbyorderid/{id}")
	public Orders getOrderByOrderId(@PathVariable("id") int id) {

		return us.getOrdersByOrderId(id);

	}

	
	@PutMapping("/update")
	public User updateUser(@RequestBody User u) {

		return us.updateUser(u);

	}

	@DeleteMapping("/delete/{id}")
	public User deleteUser(@PathVariable("id") Integer id) {

		System.out.println(id);
		return us.deleteUser(id);

	}


}
