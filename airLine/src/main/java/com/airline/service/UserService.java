package com.airline.service;

import java.util.Optional;

import com.airline.entity.User;
import com.ariline.dao.UserDao;

public class UserService {

	private UserDao userDao;
	
	public UserService() {
		userDao= new UserDao();
		
	}
	public boolean register(String name , String email, String pass) {
		boolean status = false;
		Optional<User> foundUser=userDao.findAll().stream()
		.filter(user -> user.getEmail().equalsIgnoreCase(email))
		.findFirst();
		
		if(foundUser.isPresent()) {
			throw new ResourceAlreadyExistException("User already registered with same email !!");
		}
		boolean isSaved = userDao.save(new User(0,name,email,pass));
		if(isSaved) {
			System.out.println("user Registered succesfully... ");
			status = true;
		}else {
			System.out.println(" failed to register user !!");
		}
		return status;
	}
    public User login(String email,String password) {
    	return userDao.serachUserByEmailAndPassword(email, password);
    }
}
