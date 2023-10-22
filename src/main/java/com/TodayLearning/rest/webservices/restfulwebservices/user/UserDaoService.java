package com.TodayLearning.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
 
	
	//JPA and Hibernate > to talk to "database"(as when we stored data at database) (implement this at last ) 
	
	// for now just store the data at the static arrayList there 
	
	private static List<User> users = new ArrayList<>();
	//created static empty list 
	
	//initialized it uaing the static block 
	
	//static block for starts ups initialization   later on we move on the JPA and hibernate 
	static 
	{
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve",LocalDate.now().minusYears(25)));
		users.add(new User(3, "jim", LocalDate.now().minusYears(20)));
	}
	
	private static int usersCount=3;
	public List<User> findAll()
	{
		System.out.println(users);
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate= user -> user.getId()==(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	
	public void deleteById(int id) {
		Predicate<? super User> predicate=user->user.getId()==id;
		users.removeIf(predicate);
	}
	
	
	
	public User save(User user)
	{
		user.setId(++usersCount);
		users.add(user);
		return user;  //to just show which user is added 
	}
	
	
}
