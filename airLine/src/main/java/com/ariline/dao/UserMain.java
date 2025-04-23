package com.ariline.dao;

import java.util.ArrayList;

import java.util.Collection;

import com.airline.entity.User;



public class UserMain {

	public static void main(String[] args) {
		UserDao dao=new UserDao();
	/*	User user =new User(0,"ajay","aj@gmail.com","ajay");
		System.out.println(dao.save(user));
		Collection<User> u=dao.viewAll();
		System.out.println(u);
		User us=dao.searchByMail("aj@gmail.com");
		System.out.println(us);*/
		//System.out.println(dao.searchById(5));
		System.out.println(dao.serachUserByEmailAndPassword("aj@gmail.com", null));
	}
}
