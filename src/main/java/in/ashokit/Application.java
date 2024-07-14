package in.ashokit;

import java.util.Arrays;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		UserRepository repository=context.getBean(UserRepository.class);

		User u1=new User(101, "Ramu", "Male", 25, "India");
		repository.save(u1);
		// I want to insert more than one record
		User u2=new User(102, "Raju", "Male", 25, "India");
		User u3=new User(103, "John", "Male", 30, "USA");
		User u4=new User(104, "Smith", "Male", 32, "Canada");
		repository.saveAll(Arrays.asList(u2,u3,u4));
		//retrive data based on primaryno
		/*	Optional<User>findById = repository.findById(103);
		if(findById.isPresent()) {
			System.out.println(findById.get());
		}*/
		// retrive multiple record
	/*	Iterable<User> allById	=repository.findAllById(Arrays.asList(101,102,103));
		allById.forEach(user ->{
			System.out.println(user);
		});*/
		//retrive all record from tqble
		/*Iterable<User> findAll	=repository.findAll();
		findAll.forEach(user ->{
			System.out.println(user);
		});*/
		// to get total record in table
	/*	long count=repository.count();
		System.out.println("Total number of rec:: "+ count);*/
		// to delete record
		//repository.deleteById(101);
		// retrive date based on age
/*	List<User> findByAge=repository.findByAge(25);
		findByAge.forEach(user-> {
			System.out.println(user);
		});*/
		
	/*List<User>findByAgeGreaterThanEqual	=repository.findByAgeGreaterThanEqual(30);
	findByAgeGreaterThanEqual.forEach(user->{
		System.out.println(user);
	});*/
	/*List<User>list=repository.findByCountryIn(Arrays.asList("India", "USA"));
	list.forEach(user->{
		System.out.println(user);
	});
		*/
		//retriving data from hql query
		List<User> users=repository.getAllUserHql();
		users.forEach(user->{
			System.out.println(user);
		});
		
    
	}

}
