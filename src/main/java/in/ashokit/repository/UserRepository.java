package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByAge(Integer cage);
	public List<User> findByAgeGreaterThanEqual(Integer age);
	public List<User> findByCountryIn(List<String> Countries);
	@Query(value="From User")
	public List<User> getAllUserHql();
}
