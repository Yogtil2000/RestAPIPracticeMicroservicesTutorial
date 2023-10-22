package com.TodayLearning.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;

@RestController
public class UserResource 
{
     private UserDaoService service;
     
     public UserResource(UserDaoService service)
     {
    	 this.service=service;
     }
     
     @GetMapping("/users")
     public List<User> retriveAllUsers()
     {
    	 return service.findAll();
     }
     
     
     
     // 2 main things in HATEOAS
     // EntityModel 
     // WebMvcLinkBuilder
     // so when the user hit the url for retrieve the particular user we also want to tell user as the link for expose all users by proving the that link to expose all users in proper format 
     
     // Note : we are also able to do the linking based on directly the link of the resource but suppose if later point when the link changes then issue cames as if you forget to change link below, 
     // so that's why we are directly mapping to the method name itself  (instead of hardcoding the link there )
     
     
     @GetMapping("/users/{id}")
     public EntityModel<User> retriveSpecificUser(@PathVariable int id)
     {
    	 User user = service.findOne(id);
    	 if(user==null)
    	 {
    		 throw new UserNotFoundException("id :"+id);
    	 }
    	 
    	 EntityModel<User> entityModel=EntityModel.of(user);  //wrapping the User class and creating the entityModel
    	 
    	 WebMvcLinkBuilder link = linkTo( methodOn(this.getClass()).retriveAllUsers() );
    	 //add a link to retrieve all users 
    	 entityModel.add(link.withRel("all-users"));
    	 return entityModel;  
    	 
    	 /* 
    	  {
"id": 1,
"name": "Adam",
"birthDate":[
1993,
10,
22
],
	"links":[
	{
	"rel": "all-users",
	"href": "http://localhost:8080/users"
	}
	]
}
    	  */
     }
     
     
     @DeleteMapping("/users/{id}")
     public void deleteUser(@PathVariable int id)
     {
    	 service.deleteById(id);
    	 
     }
     
     
     
     @PostMapping("/users")
     public ResponseEntity<User> createUser(@Valid @RequestBody User user)
     {
    	 //       /users/4         /users/{id}        user.getId();
    	 User savedUser = service.save(user);
    	 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
     }
     
    
     
     
     
     
}
