package com.harshu.shoppin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harshu.shoppin.dto.Users;
import com.harshu.shoppin.entity.User;

@Repository
public interface UserRepo  extends JpaRepository<User , Integer>{
	//@Query("SELECT new com.harshu.ahoppin from User u ")
	
	@Query("select new com.amazon.shoppin.dto.Users(u.id,u.name,u.email) from User u")
	List<Users> getAllUser();
}
