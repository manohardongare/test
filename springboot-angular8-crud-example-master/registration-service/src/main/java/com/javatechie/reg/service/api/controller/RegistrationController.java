package com.javatechie.reg.service.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.reg.service.api.dao.UserRepository;
import com.javatechie.reg.service.api.model.User;


@RestController
public class RegistrationController {
	
	    @Autowired
	    private UserRepository repository;
	    
	    
	    @PostMapping("/register")
	    public String register(@RequestBody User user) {
	        repository.save(user);
	        return "Hi " + user.getName() + " your Registration process successfully completed";
	    }
	    
	   
	    @GetMapping("/getAllUsers")
	    public List<User> findAllUsers() {
	        return repository.findAll();
	    }

	    @GetMapping("/findUser/{email}")
	    public List<User> findUser(@PathVariable String email) {
	        return repository.findByEmail(email);
	    }

	    @DeleteMapping("/cancel/{id}")
	    public List<User> cancelRegistration(@PathVariable int id) {
	        repository.deleteById(id);
	        return repository.findAll();
	    }
	    
	 
}
