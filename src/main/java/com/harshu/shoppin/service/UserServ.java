package com.harshu.shoppin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshu.shoppin.dto.Users;
import com.harshu.shoppin.entity.Orders;
import com.harshu.shoppin.entity.User;
import com.harshu.shoppin.repository.OrderRepo;
import com.harshu.shoppin.repository.UserRepo;

@Service
public class UserServ {
@Autowired
UserRepo  ur;

@Autowired
OrderRepo or;
 
 public User saveUser(User u) {
	 return ur.save(u);  
 }
 
  public List<Orders> getOrdersById(int id){
	  return or.getOrdersByUserId(id);
  }
//  public List<User> getAllUser(){ 
//	  return ur.getAllUser();
//	  
//	  
//  }
  public List<Users> getAllUsers() {
		List<Users> users = ur.getAllUser();

		List<Users> collect = users.stream().sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()))
				.collect(Collectors.toList());
		return collect;
	}
  
  public List<Orders> getOrders() {
		return or.findAll();
	}

	public Orders getOrdersByOrderId(int id) {

		Optional<Orders> findById = or.findById(id);
		Orders orders = findById.get();
		return orders;
	}

	public User updateUser(User u) {

		return ur.save(u);
	}

	public User deleteUser(int id) {

		try {  

			 Optional<User> findById = ur.findById(id);

			User user = findById.get();

			ur.deleteById(id);

			return user;

		} catch (Exception e) {
			System.out.println("user not with this id  ");
		}

		return null;

	}

}
